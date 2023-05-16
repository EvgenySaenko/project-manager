
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

insert into project(name) values ('Проект 1'),
                                 ('Проект 2'),
                                 ('Проект 3'),
                                 ('Проект 4'),
                                 ('Проект 5');

insert into subproject(name, project_id) values ('Подпроект 1', 1),
                                                ('Подпроект 2', 1),
                                                ('Подпроект 3', 2),
                                                ('Подпроект 4', 3),
                                                ('Подпроект 5', 3),
                                                ('Подпроект 5', 3),
                                                ('Подпроект 5', 4),
                                                ('Подпроект 6', 5);

insert into task(name, type, status, description, project_id, subproject_id, owner_id)
values ('Задача 1', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 1, null, 1),
       ('Задача 2', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 1, null, 1),
       ('Задача 3', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2, 1),
       ('Задача 4', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2, 2),
       ('Задача 5', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2, 2),
       ('Задача 6', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 2, null, 2),
       ('Задача 7', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3, 2),
       ('Задача 8', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3, 2),
       ('Задача 1', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3, 2),

       ('Задача 10', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 4, 1),
       ('Задача 11', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 4, 1),
       ('Задача 12', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null, 2),
       ('Задача 13', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null, 1),
       ('Задача 14', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null, 1),
       ('Задача 15', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 4, null, 2),
       ('Задача 16', 'MANAGER', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 5, 2),
       ('Задача 17', 'TECHNICAL_SPECIALIST', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 5, 2);

