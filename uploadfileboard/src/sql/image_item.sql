create table image_item(
    item_id integer(5) auto_increment,
    item_name varchar(20),
    price integer(6),
    description varchar(50),
    picture_url varchar(200),
    primary key (item_id)
);