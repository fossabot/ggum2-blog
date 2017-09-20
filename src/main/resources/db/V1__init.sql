CREATE TABLE USER (
  id varchar(100) not null primary key,
  password varchar(255) not null,
  name varchar(50) not null,
  nickname varchar(50) not null UNIQUE,
  role varchar(20) not null default 'FRIEND',
  created datetime not null default NOW(),
  updated datetime not null default NOW(),
  password_changed datetime not null default NOW(),
  is_enabled tinyint(1) not null default false,
  is_account_non_expired tinyint(1) not null default true,
  is_account_non_locked tinyint(1) not null default true,
  is_credentials_non_expired tinyint(1) not null default true
);

