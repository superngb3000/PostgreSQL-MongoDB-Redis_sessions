package com.example.pr4.controllers;

import com.example.pr4.models.File;
import com.example.pr4.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping
    public String addFile(@RequestParam("title") String title,
                           @RequestParam("file") MultipartFile file,
                          HttpServletResponse response,
                           Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        if (!fileName.substring(fileName.length()-3, fileName.length()).equals("pdf")) {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        } else {
            fileService.addFile(title, file);
        }
        return "redirect:/files";
    }

    @GetMapping
    public String getAll(Model model){
        List<File> files = fileService.getAll();
        model.addAttribute("files", files);
        return "files";
    }

    @ResponseBody
    @GetMapping("/{id}")
    public void downloadFile(@PathVariable String id, HttpServletResponse response) throws IOException {
        File file = fileService.getFile(id);
        FileCopyUtils.copy(file.getStream(), response.getOutputStream());
    }

    @PostMapping("/delete/{id}")
    public String addFile(@PathVariable String id) throws IOException {
        fileService.deleteFile(id);
        return "redirect:/files";
    }
}
