--사원정보 테이블.
create table employee (
 emp_no number primary key, -- 사원번호
 emp_name varchar2(50) not null, --사원명
 email varchar2(30) not null, --이메일
 phone varchar2(10) not null, --연락처
 hire_date date default sysdate, --입사일자
 salary number default 100,
 department varchar2(30) not null, --부서
 create_date date default sysdate
);

insert into employee (emp_no, emp_name, email, phone, salary, department, hire_date)
values(108, '홍길동', 'hong@mail.com', '234-5678', 200, '인사', to_date('2023-01-05', 'yyyy-mm-dd'));
insert into employee (emp_no, emp_name, email, phone, salary, department)
values(102, '김사원', 'kim@mail.com', '234-5679', 300, '총무');
insert into employee (emp_no, emp_name, email, phone, salary, department)
values(103, '최주임', 'choi@mail.com', '234-5978', 400, '개발');

select * from employee;

update employee
set salary = salary + 50
where emp_no = 101;

select *
from employee
--where department = '인사'
order by 1 desc
;

select department, count(*) from employee
group by department
; --78건.

delete from employee where emp_no = 208;

insert into employee(emp_no
           ,emp_name
           ,email
           ,phone
           ,hire_date
           ,salary
           ,department)
select emp_no+100 --(select max(emp_no)+1 from employee)
           ,emp_name
           ,email
           ,phone
           ,hire_date
           ,salary
           ,department
from employee; -- 30건 이상 데이터 생성.

--페이징. 페이지당 5개씩 출력.
--78건 > 16페이지
-- 1페이지: 5건, 사원번호 기준으로..
-- 1page: 1 ~ 5, 2page: 6 ~ 10
select emp_no
      ,emp_name
      ,email
      ,phone
      ,hire_date
      ,salary
      ,department
from (select rownum rn, a.*
      from (select *
            from employee
            where department = nvl(:dept, department)
            order by emp_no) a ) b
where b.rn > (:page -1 ) * 5 and b.rn <= (:page)*5;


select * from employee
where department = nvl('개발', department) ;

select rn 
      ,emp_no
      ,emp_name
      ,email
      ,phone
      ,hire_date
      ,salary
      ,department
from (select /*+ INDEX_DESC(e SYS_C008368) */ 
      rownum rn, e.*
      from employee e
      where rownum <= 10) a
where rn > 0;


create table tbl_board (
 board_no number,
 title varchar2(50) not null,
 content varchar2(300) not null,
 writer varchar2(20) not null,
 view_cnt number default 0,
 create_date date default sysdate
);
alter table tbl_board add constraint board_pk primary key (board_no);
alter table tbl_board add update_date date default sysdate;

create sequence board_seq;

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, 'title3', 'content3', 'user01');

insert into tbl_board (board_no, title, content, writer)
select board_seq.nextval, 'title'||board_seq.currval, 'content'||board_seq.currval, writer
from tbl_board;

select board_no
      ,title
      ,content
      ,writer
      ,view_cnt
      ,create_date
      ,update_date
from (select /*+ INDEX(b board_pk)*/
      rownum rn, b.* 
      from tbl_board b
      where writer = nvl(:writer, writer)
      and   title like '%'||:title||'%'
      and   rownum <= :page * 5
      ) a
where rn > (:page - 1) * 5;

