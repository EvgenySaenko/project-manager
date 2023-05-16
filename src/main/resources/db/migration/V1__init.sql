
drop table if exists users;
create table users (
   id                    bigserial primary key,
   username              VARCHAR(30) NOT NULL UNIQUE,
   password              VARCHAR(80) NOT NULL,
   created_at            timestamp default current_timestamp,
   updated_at            timestamp default current_timestamp
);


drop table if exists roles;
create table roles (
   id                    bigserial primary key,
   name                  VARCHAR(50) not null UNIQUE,
   created_at            timestamp default current_timestamp,
   updated_at            timestamp default current_timestamp
);


drop table if exists users_roles;
create table users_roles (
   user_id               bigint NOT NULL references users (id),
   role_id               bigint NOT NULL references roles (id),
   primary key (user_id, role_id)
);


insert into roles (name) values ('ROLE_USER'),
                                ('ROLE_ADMIN');


insert into users (username, password) values
                                ('user','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i'),
                                ('admin','$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i');


insert into users_roles (user_id, role_id) values
                                    (1, 1),
                                    (2, 2);


drop table if exists project cascade;
create table project (
     id                         bigserial primary key,
     name                       varchar (255) not null,
     created_at                 timestamp default current_timestamp,
     updated_at                 timestamp default current_timestamp
);


drop table if exists subproject cascade;
create table subproject (
     id                        bigserial primary key,
     name                      varchar(255) not null,
     project_id                bigint not null,
     created_at                timestamp default current_timestamp,
     updated_at                timestamp default current_timestamp,
     constraint fk_project_id foreign key (project_id) references project (id)
);

drop table if exists task cascade;
create table task (
     id                        bigserial primary key,
     name                      varchar(255) not null,
     type                      varchar(255) not null,
     status                    varchar(255) not null,
     description               varchar(255) not null,
     project_id                bigint,
     subproject_id             bigint,
     owner_id                  bigint references users (id),
     created_at                timestamp default current_timestamp,
     updated_at                timestamp default current_timestamp,
     constraint fk_project_id2 foreign key (project_id) references project (id),
     constraint fk_subproject_id foreign key (subproject_id) references subproject (id)
);

insert into project(name) values ('Project 1'),
                                 ('Project 2'),
                                 ('Project 3'),
                                 ('Project 4'),
                                 ('Project 5');

insert into subproject(name, project_id) values ('Subproject 1', 1),
                                                ('Subproject 2', 1),
                                                ('Subproject 3', 2),
                                                ('Subproject 4', 3),
                                                ('Subproject 5', 3),
                                                ('Subproject 5', 3),
                                                ('Subproject 5', 4),
                                                ('Subproject 6', 5);

insert into task(name, type, status, description, project_id, subproject_id, owner_id)
values ('Task 1', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', 1, null, 1),
       ('Task 2', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', 1, null, 1),
       ('Task 3', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', null, 2, 1),
       ('Task 4', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 2, 2),
       ('Task 5', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 2, 2),
       ('Task 6', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', 2, null, 2),
       ('Task 7', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', null, 3, 2),
       ('Task 8', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 3, 2),
       ('Task 1', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 3, 2),

       ('Task 10', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', null, 4, 1),
       ('Task 11', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 4, 1),
       ('Task 12', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', 3, null, 2),
       ('Task 13', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', 3, null, 1),
       ('Task 14', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', 3, null, 1),
       ('Task 15', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', 4, null, 2),
       ('Task 16', 'MANAGER', 'NEW', 'A complete description of the task that needs to be fixed!', null, 5, 2),
       ('Task 17', 'TECHNICAL_SPECIALIST', 'NEW', 'A complete description of the task that needs to be fixed!', null, 5, 2);

