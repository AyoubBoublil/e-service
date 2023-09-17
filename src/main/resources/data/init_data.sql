-- Add roles into table role
INSERT INTO "e-service"."e-service".role (id, enabled, created_by, created_date, last_modified_by, last_modified_date, name)
VALUES (1, 1, 'ROOT', CURRENT_TIMESTAMP, 'ROOT', current_timestamp, 'ROLE_ADMIN');
INSERT INTO "e-service"."e-service".role (id, enabled, created_by, created_date, last_modified_by, last_modified_date, name)
VALUES (2, 1, 'ROOT', CURRENT_TIMESTAMP, 'ROOT', current_timestamp, 'ROLE_TEACHER');
INSERT INTO "e-service"."e-service".role (id, enabled, created_by, created_date, last_modified_by, last_modified_date, name)
VALUES (3, 'ROOT', CURRENT_TIMESTAMP, 'ROOT', current_timestamp, 'ROLE_STUDENT');

-- add user into table user
INSERT INTO "e-service"."e-service".user (id, enabled, created_by, created_date, last_modified_by, last_modified_date, first_name, last_name, email, phone, password)
VALUES (1, 1, 'ROOT', CURRENT_TIMESTAMP, 'ROOT', current_timestamp, 'Ayoub', 'Boublil', 'ayoub@gmail.com', '0698745231', '$2a$10$rJnXkiDFTIWNOZOmy8A6UuLW.HebQc9Yvrp3eqtxZ8u.nWkzwrgyG');

-- Assign the admin role to user
insert into "e-service"."e-service".user_roles(role_id, user_id) values (1, 1);