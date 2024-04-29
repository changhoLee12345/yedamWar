drop table tbl_member purge;
create table tbl_member (
  member_id varchar2(10) primary key,
  member_pw varchar2(10) not null,
  member_nm varchar2(50) not null,
  responsibility varchar2(10) default 'User',
  create_date date default sysdate,
  phone varchar2(20)
);