
create table member (
 id varchar2(10) primary key,
 name varchar2(100) not null,
 passwd varchar2(10) not null,
 mail varchar2(30) not null
);
insert into member values ('user1' ,'사용자1', '1234', 'user1@email');

drop table test_board purge;
create table test_board (
	seq number,
	title varchar2(100),
	writer varchar2(100),
	content varchar2(500),
	write_date date,
	visit_cnt number,
	image varchar2(500)
);
alter table test_board add constraint pk_board primary key(seq);
drop sequence board_seq;
create sequence board_seq;

insert into test_board values(board_seq.nextval, '글번호'||board_seq.currval, '작성자1', '글내용'||board_seq.currval, sysdate, 0);
insert into test_board values(board_seq.nextval, '글번호'||board_seq.currval, '작성자2', '글내용'||board_seq.currval, sysdate, 0);
insert into test_board values(board_seq.nextval, '글번호'||board_seq.currval, '작성자3', '글내용'||board_seq.currval, sysdate, 0);

insert into test_board
(select board_seq.nextval, '글번호'||board_seq.currval, writer, '글내용'||board_seq.currval, sysdate, 0 from test_board);

select seq, title, content, writer, write_date, visit_cnt
from (select /*+ index_desc(test_board pk_board) */ 
             rownum rn, seq, title, content, writer, write_date, visit_cnt
      from test_board 
      where rownum <= 20)
where rn > 10;

select count(1) from test_board;

