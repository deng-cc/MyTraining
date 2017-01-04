# 概述
本题目的表结构大致如下图所示，具体的建表及测试数据可以参考原博主的博客。<br>

我已经连通练习过一次并记录在了为知笔记中，也借此得到了很大的锻炼。这一次进行第二次练习熟悉，也顺便录入到Github中来。<br>

另，本篇中的题目，前半部分难度稍大，后半部分难度减小。<br>

<img src="https://github.com/deng-cc/MyTraining/blob/master/pics/sql/sql_student_01.jpg?raw=true" width="600"  />


# 练习

1）查询“001”课程比“002”课程成绩高的所有学生的学号

``` stylus
select
  s1.StudentNo
from 
  score s1, 
  score s2
where 
  s1.CourseNo = 001 
  and 
  s2.CourseNo = 002 
  and 
  s1.StudentNo = s2.StudentNo
  and
  s1.score > s2.score
```
<br>
2） 查询平均成绩大于60分的同学的学号和平均成绩

``` stylus
select
  s1.StudentNo,
  AVG(s1.score)
from
  score s1
  group by s1.StudentNo
  having AVG(s1.score) > 60
```
<br>
3）查询所有同学的学号、姓名、选课数、总成绩

``` stylus
select
  stu1.studentNo,
  stu1.name,
  count(s1.CourseNo),
  sum(s1.score)
from
  score s1,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  group by s1.StudentNo
```
<br>
4）查询姓“李”的老师的个数

``` stylus
select
  count(*)
from
  teacher t1
where
  t1.name like '李%'
```
<br>
5）查询没学过“叶平”老师课的同学的学号、姓名

``` stylus
select
  stu1.studentNo,
  stu1.name
from
  student stu1
where
  stu1.studentNo not in
  (
  --学过叶平老师课的学生学号
  select distinct
    s1.StudentNo
  from
    score s1,
    course c1,
    teacher t1
  where
    s1.CourseNo = c1.courseNo
    and
    c1.teacherNo = t1.teacherNo
    and
    t1.name = '叶平'
  )
```
<br>
6）查询学过“001”并且也学过编号“002”课程的同学的学号、姓名

``` stylus
select
  stu1.studentNo,
  stu1.name
from
  score s1,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  and
  s1.CourseNo = 001
  and
  s1.StudentNo in
  (
  select distinct
    s2.StudentNo
  from
    score s2
  where
    s2.CourseNo = 002
  )
```
<br>
7）查询学过“叶平”老师所教的所有课的同学的学号、姓名

``` stylus
select
  s1.StudentNo,
  stu1.name
from
  score s1,
  student stu1,
  course c1,
  teacher t1
where
  s1.StudentNo = stu1.studentNo
  and
  s1.CourseNo = c1.courseNo
  and
  c1.teacherNo = t1.teacherNo
  and
  t1.name = '叶平'
  group by s1.StudentNo
  having count(c1.courseNo)=
  (
    select
      count(c2.courseNo)
    from
      course c2,
      teacher t2
    where
      c2.teacherNo = t2.teacherNo
      and
      t2.name = '叶平'
   )
```
<br>
8）查询课程编号“002”的成绩比课程编号“001”课程低的所有同学的学号、姓名（和第1题是重复的）

``` stylus
select
  s1.StudentNo,
  stu1.name
from
  score s1,
  score s2,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  and
  s1.CourseNo = 001
  and
  s2.CourseNo = 002
  and
  s1.StudentNo = s2.StudentNo
  and
  s1.score > s2.score
```
<br>
9）查询有课程成绩小于60分的同学的学号、姓名

``` stylus
select distinct
  s1.StudentNo,
  stu1.name
from
  score s1,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  and
  s1.score < 60
```
<br>
10）查询没有学全所有课的同学的学号、姓名

``` stylus
select
  s1.StudentNo,
  stu1.name
from
  score s1,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  group by s1.StudentNo
  having count(s1.CourseNo) <
  (
  select
    count(*)
  from
    course c1
  )
```
<br>
















