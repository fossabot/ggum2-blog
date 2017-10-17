CREATE TABLE USERS (
  id varchar(100) not null primary key,
  password varchar(255) not null,
  name varchar(50) not null,
  nickname varchar(50) not null UNIQUE,
  role varchar(20) not null default 'FRIEND',
  is_enabled tinyint(1) not null default true
);

