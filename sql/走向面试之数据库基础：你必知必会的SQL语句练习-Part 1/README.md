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
11）查询至少有一门课与学号为“001”的同学所学相同的同学的学号和姓名

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
  s1.CourseNo in
  (
  select
    s2.CourseNo
  from
    score s2
  where
    s2.StudentNo = 001
  )
```
<br>
12）查询至少学过学号为“001”同学所有一门课的其他同学学号和姓名（和11题几乎一样）
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
  s1.StudentNo != 001
  and
  s1.CourseNo in
  (
  select
    s2.CourseNo
  from
    score s2
  where
    s2.StudentNo = 001
  )
```
<br>
13）把“SC”表中“叶平”老师教的课的成绩都更改为此课程的平均成绩
<br>
这道题有两个点需要注意：
- MySQL中不支持先select同一表中的某值，再update这个表，所以需要采用再select的方式来提取值；
- 个人理解的该题的题意是，假设叶平老师教授了A课和B课，那么课程A改为课程A的平均成绩，课程B改为课程B的平均成绩。实际上我写出的是课程A和B的成绩都改为A和B成绩的平均成绩。所以实际上我认为以下的写法是有违题意的，但是按照理解的题意，暂未想到合适的sql语句，故此搁浅，隔日再审。

``` stylus
update 
  score s1
set
  s1.score = 
  (
  select
    table1.avgScore
  from
    (
    select
      avg(s2.score) as avgScore
    from
      score s2,
      course c2,
      teacher t2
    where
      s2.CourseNo = c2.courseNo
      and
      c2.teacherNo = t2.teacherNo
      and
      t2.name = '叶平'
    )table1  
  )
  
where
  s1.CourseNo in
  (
  select
    c1.courseNo
  from
    course c1,
    teacher t1
  where
    c1.teacherNo = t1.teacherNo
    and
    t1.name = '叶平'
  )
```
<br>
14）查询和“002”号的同学学习的课程完全相同的其他同学学号和姓名
<br>
这里利用了CourseNo作为主键唯一的特性，不同人的各课程相加的值也不同，如果相同，那么所学课程必定相同。
``` stylus
select
  s1.StudentNo,
  stu1.name
from
  score s1,
  student stu1
where
  s1.StudentNo = stu1.studentNo
  and
  s1.StudentNo != 2
  group by s1.StudentNo
  having sum(s1.CourseNo) =
  (
  select
    sum(s2.CourseNo)
  from
    score s2
  where
    s2.StudentNo = 2
  )
```
5）删除学习“叶平”老师课的SC表记录

``` stylus
delete from 
  score s1
where
  s1.CourseNo in
  (
  select
    c1.courseNo
  from
    course c1,
    teacher t1
  where
    c1.teacherNo = t1.teacherNo
    and
    t1.name = '叶平'
  )

```














