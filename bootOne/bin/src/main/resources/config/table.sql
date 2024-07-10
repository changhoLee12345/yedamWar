create table tbl_book (
 book_code varchar2(10) primary key,
 book_title varchar2(100) not null,
 book_title varchar2(100) not null,
 book_press varchar2(100) not null,
 book_price number default 0
);


create table tbl_product (
  product_code char(4) primary key, -- P001, P002, P003....
  product_name varchar2(100) not null,
  product_desc varchar2(300) not null,
  sale_price number not null,
  off_price number not null,
  like_it number(1) default 5
);