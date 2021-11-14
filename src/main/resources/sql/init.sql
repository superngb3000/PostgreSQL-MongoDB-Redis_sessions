-- create table if not exists roles_table(
--     id serial primary key not null,
--     name text not null
-- );
--
-- create table if not exists users_table(
--     id serial primary key not null,
--     username text not null unique,
--     password text not null,
--     email text not null unique
-- );
--
-- create table if not exists items_table(
--     id serial primary key not null,
--     name text not null,
--     price float8 not null,
--     description text
-- );
--
-- create table if not exists users_table_roles(
--     users_id serial not null,
--     roles_id serial not null
-- );
--
--
--  INSERT INTO roles_table (id, name) VALUES (1, 'ROLE_USER') ON CONFLICT DO NOTHING;
--  INSERT INTO roles_table (id, name) VALUES (2, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;
--
--  INSERT INTO users_table (id, username, password, email) VALUES (0, 'admin', 'admin','javatemplates03@gmail.com') ON CONFLICT (id) DO NOTHING;
--  INSERT INTO users_table_roles (users_id, roles_id) VALUES (0, 1) ON CONFLICT DO NOTHING;
--  INSERT INTO users_table_roles (users_id, roles_id) VALUES (0, 2) ON CONFLICT DO NOTHING;
--
--  create extension if not exists pgcrypto;
--  update users_table set password = crypt(password, gen_salt('bf', 10));
--
-- -- INSERT INTO items_table (id, name, price, description) VALUES (0, 'AMD Ryzen 9 5950X', 92133, 'процессор') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (1, 'ASUS TUF GAMING GEFORCE RTX 3090', 389990, 'видеокарта') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (2, 'ASUS ROG Crosshair VIII Hero', 39990, 'материнская плата') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (3, 'CORSAIR Dominator Platinum RGB 2x', 15490, 'оперативная память') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (4, 'Gigabyte AORUS NVMe Gen4', 12890, 'ssd накопитель') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (5, 'WD Gold (WD121KRYZ)', 106790, 'жесткий диск') ON CONFLICT (id) DO NOTHING;
-- -- INSERT INTO items_table (id, name, price, description) VALUES (6, 'Cooler Master MasterWatt Maker 1200', 21847, 'блок питания') ON CONFLICT (id) DO NOTHING;
