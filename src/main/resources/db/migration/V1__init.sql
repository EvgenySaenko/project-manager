
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


insert into roles (name) values ('USER'),
                                ('ADMIN');


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
     status                    varchar(255) not null,
     description               varchar(255) not null,
     project_id                bigint,
     subproject_id             bigint,
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

insert into task(name, status, description, project_id, subproject_id)
values ('Задача 1', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 1, null),
       ('Задача 2', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 1, null),
       ('Задача 3', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2),
       ('Задача 4', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2),
       ('Задача 5', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 2),
       ('Задача 6', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 2, null),
       ('Задача 7', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3),
       ('Задача 8', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3),
       ('Задача 1', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 3),

       ('Задача 10', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 4),
       ('Задача 11', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 4),
       ('Задача 12', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null),
       ('Задача 13', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null),
       ('Задача 14', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 3, null),
       ('Задача 15', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', 4, null),
       ('Задача 16', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 5),
       ('Задача 17', 'NEW', 'Полное описание задачи, что именно нужно выполнить!', null, 5);

