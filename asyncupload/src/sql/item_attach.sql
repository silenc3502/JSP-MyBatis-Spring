create table item_attach(
    fullname varchar(150) not null,
    item_id integer(5) not null,
    regdate timestamp default now(),
    primary key (fullname)
);

alter table item_attach add constraint fk_item_attach foreign key (item_id) references async_image_item (item_id);