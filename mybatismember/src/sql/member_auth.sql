create table member_auth(
    user_no integer(5) not null,
    auth varchar(50) not null
);

alter table member_auth add constraint fk_member_auth_user_no foreign key (user_no) references member (user_no);