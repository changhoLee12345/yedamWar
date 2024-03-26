ALTER session SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER dev identified BY dev;
grant CONNECT, RESOURCE, CREATE view TO dev;
grant debug connect session to dev;
ALTER USER dev DEFAULT tablespace users quota unlimited ON users;

ALTER USER hr identified BY hr account unlock;

SELECT *
FROM   all_users
ORDER  BY 1;

ALTER session SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER hr identified BY hr;
CREATE USER dev identified BY dev DEFAULT tablespace users temporary tablespace temp;

grant CONNECT, RESOURCE TO bbs;
grant CONNECT, dba TO book_ex;

ALTER USER bbs DEFAULT tablespace users quota unlimited ON users;

drop table tbl_board purge;
create table tbl_board (
bno number ,
title varchar2(100),
content varchar2(500),
writer varchar2(100));
alter table tbl_board add constraint pk_board primary key(bno);

drop sequence seq_board;
create sequence seq_board;

insert into tbl_board values(seq_board.nextval, 'test1', 'content1', 'user1');
insert into tbl_board values(seq_board.nextval, 'test2', 'content2', 'user2');
insert into tbl_board values(seq_board.nextval, 'test3', 'content3', 'user3');

delete from tbl_board where bno > 0;
select * from tbl_board order by bno desc;

select /*+ INDEX_ASC(tbl_board pk_board) */
* from tbl_board where bno > 0;

insert into tbl_board (bno, title, content, writer) 
(select seq_board.nextval, title, content, writer from tbl_board);

select /*+ INDEX_ASC(tbl_board pk_board) */ 
rownum, bno, title from tbl_board
where bno > 0;

select bno, title, content
from (select /*+ index_asc(tbl_board pk_board) */ 
             rownum rn, bno, title, content 
      from tbl_board 
      where rownum <= 20)
where rn > 10;

insert into test_board
(select board_seq.nextval, '글번호'||board_seq.currval, '작성자3', '글내용'||board_seq.currval, sysdate, 0 from test_board);
