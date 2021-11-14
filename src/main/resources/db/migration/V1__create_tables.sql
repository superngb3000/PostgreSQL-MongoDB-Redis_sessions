create table if not exists roles_table(
                                          id serial primary key not null,
                                          name text not null
);

create table if not exists users_table(
                                          id serial primary key not null,
                                          username text not null unique,
                                          password text not null,
                                          email text not null unique
);

create table if not exists items_table(
                                          id serial primary key not null,
                                          name text not null,
                                          price float8 not null,
                                          description text
);

create table if not exists users_table_roles(
                                                users_id serial not null,
                                                roles_id serial not null
);