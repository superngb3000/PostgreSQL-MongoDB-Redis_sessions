INSERT INTO roles_table (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO roles_table (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_table (id, username, password, email) VALUES (0, 'admin', 'admin','javatemplates03@gmail.com');
INSERT INTO users_table_roles (users_id, roles_id) VALUES (0, 1);
INSERT INTO users_table_roles (users_id, roles_id) VALUES (0, 2);