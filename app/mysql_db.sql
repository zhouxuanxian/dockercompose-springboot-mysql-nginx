create database encryted_system default character set = 'utf8';
use encryted_system;
create table User
(
    `id` int(11) NOT NULL AUTO_INCREMENT primary key,
-- fk_user_id INT(11) not null,
    user_name varchar(30) not null,
    password varchar(30)
);
create table UserData
(
    `id` int(11) NOT NULL AUTO_INCREMENT primary key,
    user_id INT(11) not null,
    qq varchar(255) not null,
    `name` varchar(255) not null,
    content varchar(255) not null,
    public_key text,
    private_key text,
    `encryted_data` text,
    created_at TIMESTAMP
);

