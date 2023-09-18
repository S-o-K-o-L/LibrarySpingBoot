create sequence author_seq start with 1 increment by 50;
create sequence book_seq start with 1 increment by 50;
create sequence chapter_seq start with 1 increment by 50;
create sequence users_seq start with 1 increment by 50;

create extension pg_trgm;
--insert into user_book (book_id, user_id) VALUES (1,1);
--insert into chapter (number, book_id, id, content) VALUES (12, 1, 1, 'asdadasdasd');

create table author
(
    id         bigint not null,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);
create table author_book
(
    author_id bigint not null,
    book_id   bigint not null,
    primary key (author_id, book_id)
);
create table book
(
    id          bigint not null,
    description text,
    name        varchar(255),
    genres      text[],
    primary key (id)
);
create table chapter
(
    number  integer,
    book_id bigint not null,
    id      bigint not null,
    content text,
    primary key (id),
    constraint UK5sqvtd7ecpcs18crru2fnt3gk unique (number, book_id)
);
create table user_book
(
    book_id bigint not null,
    user_id bigint not null,
    primary key (book_id, user_id)
);
create table users
(
    id               bigint       not null,
    first_name       varchar(255),
    last_name        varchar(255),
    login            varchar(255) not null unique,
    password         varchar(255) not null unique,
    role             varchar(255) check (role in ('ADMIN', 'USER')),
    telephone_number varchar(255),
    primary key (id)
);
alter table if exists author_book
    add constraint FKn8665s8lv781v4eojs8jo3jao foreign key (book_id) references book;
alter table if exists author_book
    add constraint FKg7j6ud9d32ll232o9mgo90s57 foreign key (author_id) references author;
alter table if exists chapter
    add constraint FKfxaijiug52tyrl5ifextmcfqb foreign key (book_id) references book;
alter table if exists user_book
    add constraint FK85pwltn867pjxog1gk5smtqcw foreign key (book_id) references book;
alter table if exists user_book
    add constraint FKhon6i1tqj4tp43386dq6uo9ch foreign key (user_id) references users