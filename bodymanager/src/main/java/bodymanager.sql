create table timetable(
  tt_num number,
  title varchar2(30) not null,
  content varchar2(30) not null,
  charge NUMBER(8,2) default 0,
  goal varchar2(100) not null,
  primary key(tt_num),
  unique(content),
  unique(goal)
)

--테이블에 자기 유저 번호도 넣어서 외래키로 넣어야함
drop sequence tt_num_seq;
create sequence tt_num_seq
start with 1
INCREMENT by 1;

insert into timetable values(tt_num_seq.nextval, 'study', 'spanish',10000, '주재원');
insert into timetable values(tt_num_seq.nextval, 'study', 'english',2000, '부자되기');
insert into timetable values(tt_num_seq.nextval, 'study', 'chinese',3000, 'vision !!');


insert into timetable values(tt_num_seq.nextval, 'investment', 'apartment !',10000, '인 서울 투기');
insert into timetable values(tt_num_seq.nextval, 'investment', 'officetel',2000, '임대');


insert into timetable values(tt_num_seq.nextval, 'diet', 'fistgym !',120000, '건강하게 살빼기');

select * from timetable;


