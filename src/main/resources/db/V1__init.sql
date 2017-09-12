CREATE TABLE USER (
  username varchar(50) not null primary key,
  password varchar(50) not null,
  name varchar(50) not null,
  role varchar(20) not null default 'FRIEND',
  is_enabled tinyint(1) default false,
  created datetime not null default NOW()
);

INSERT INTO USER (username, password, name, role, is_enabled)
  SELECT 'admin@ggum2.net', 'P@ssw0rd', 'Hyunsoo Jung', 'ADMIN', TRUE FROM dual
  WHERE NOT EXISTS(SELECT * FROM USER WHERE username = 'admin@ggum2.net');