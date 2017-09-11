CREATE TABLE USER (
  username varchar(50) not null primary key,
  password varchar(50) not null,
  name varchar(50) not null,
  role varchar(20) not null default 'FRIEND',
  isEnabled tinyint(1) default false,
  created datetime not null default NOW()
);

INSERT INTO USER (username, password, name, role, isEnabled)
VALUES ('admin@ggum2.net', 'P@ssw0rd', 'Hyunsoo Jung', 'ADMIN', TRUE);
