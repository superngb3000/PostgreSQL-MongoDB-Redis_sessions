package com.example.pr4.services;


import com.example.pr4.models.Role;
import com.example.pr4.models.User;
import com.example.pr4.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public String addUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return "Пользователь с таким именем уже существует";
        }
        if(userRepository.findByEmail(user.getEmail()) != null){
            return "Пользователь с таким Email уже существует";
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    //    sendSignUpMessage(user);
        return "";
    }

    public void deleteUser(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(id);
            return;
        }
    }

    public User findById(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    private void sendSignUpMessage(User user){
        if(user.getEmail() != null){
            String message = user.getUsername() + ", поздравляем с успешной регистрацией аккаунта!\n";
            emailService.send(user.getEmail(), "Регистрация аккаунта", message);
            return;
        }
    }

    public User saveUser(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            return null;
        }
        if(userRepository.findByEmail(user.getEmail()) != null){
            return null;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    //    sendSignUpMessage(user);
        return user;
    }

    public User updateUser(User user, Long id){
        Optional<User> tmpOptional = userRepository.findById(id);
        if (tmpOptional.isPresent()){
            User tmp = tmpOptional.get();
            tmp.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            tmp.setEmail(user.getEmail());
            tmp.setUsername(user.getUsername());
            return tmp;
        }
        return null;
    }
}
