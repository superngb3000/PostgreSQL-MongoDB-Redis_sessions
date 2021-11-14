create extension if not exists pgcrypto;
update users_table set password = crypt(password, gen_salt('bf', 10));