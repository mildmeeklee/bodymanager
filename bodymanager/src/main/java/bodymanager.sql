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

--���̺� �ڱ� ���� ��ȣ�� �־ �ܷ�Ű�� �־����
drop sequence tt_num_seq;
create sequence tt_num_seq
start with 1
INCREMENT by 1;

insert into timetable values(tt_num_seq.nextval, 'study', 'spanish',10000, '�����');
insert into timetable values(tt_num_seq.nextval, 'study', 'english',2000, '���ڵǱ�');
insert into timetable values(tt_num_seq.nextval, 'study', 'chinese',3000, 'vision !!');


insert into timetable values(tt_num_seq.nextval, 'investment', 'apartment !',10000, '�� ���� ����');
insert into timetable values(tt_num_seq.nextval, 'investment', 'officetel',2000, '�Ӵ�');


insert into timetable values(tt_num_seq.nextval, 'diet', 'fistgym !',120000, '�ǰ��ϰ� �컩��');

select * from timetable;


