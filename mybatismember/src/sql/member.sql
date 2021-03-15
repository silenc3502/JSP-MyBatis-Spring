create table member(
    user_no integer(5) auto_increment,
    user_id varchar(50) not null,
    user_pw varchar(100) not null,
    user_name varchar(100) not null,
    coin integer(10) default 0,
    reg_date timestamp default now(),
    upd_date timestamp default now(),
    enabled char(1) default '1',
    primary key (user_no)
);