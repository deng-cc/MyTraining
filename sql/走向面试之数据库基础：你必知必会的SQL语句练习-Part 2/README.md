# 概述
具体的建表数据，参考原博地址：<br>
[走向面试之数据库基础：一、你必知必会的SQL语句练习-Part 2][1]

# 开练！
1）找出借书至少2本的读者,输出借书卡号及所借图书册数

``` stylus
select
  b.cardId,
  count(*)
from
  borrow b
  group by b.cardId
  having count(*)>=2
```
<br>

2）查询借阅了"水浒"一书的读者，输出姓名及班级

``` stylus
select
  c.name,
  c.class
from
  borrow b,
  books bk,
  cards c
where
  b.bookId = bk.id
  and
  bk.name = '水浒'
  and
  b.cardId = c.id
```
<br>

3）查询目前为止未还图书，输出借阅者（卡号）、书号及还书日期

``` stylus
select
  b.cardId,
  b.bookId,
  b.returnDate
from
  borrow b
where
  b.returnDate > current_date
```
<br>

4）查询书名包括"网络"关键词的图书，输出书号、书名、作者

``` stylus
select
  b.id,
  b.name,
  b.author
from
  books b
where
  b.name like '%网络%'
```
<br>

5）查询现有图书中价格最高的图书，输出书名及作者

``` stylus
select
  bk.name,
  bk.author
from
  books bk
where
  bk.price = (select max(b.price) from books b)
```
<br>

6）查询当前借了"计算方法"但没有借"计算方法习题集"的读者，输出其借书卡号，并按卡号降序排序输出

``` stylus
select
  b1.cardId
from
  borrow b1,
  books bk1
where
  b1.bookid = bk1.id
  and
  bk1.name = '计算方法' 
  and
  b1.cardId not in
  (
  select
    b2.cardId
  from
    borrow b2,
    books bk2
  where
    b2.bookid = bk2.id
    and
    bk2.name = '计算方法习题集'
  )
order by b1.cardId desc
```
<br>

7）将"计科一班"班同学所借图书的还期都延长一周
<br>
**用到MySQL的时间函数**
``` stylus
update
  borrow b1,
  cards c1
set
  b1.returnDate = DATE_ADD(b1.returnDate, interval 7 day)
where
  b1.cardId = c1.id
  and
  c1.class = '计科一班'
```
<br>

8）从BOOKS表中删除当前无人借阅的图书记录

``` stylus
delete from books bk
where bk.id not in
(
select distinct b.bookId from borrow b
)
```
<br>

9）如果经常按书名查询图书信息，请建立合适的索引
<br>
**很少用，虽然很简单也标注下重点**

``` stylus
create index index_bookName on books(name)
```
<br>

10）建立一个视图，显示"计科一班"班学生的借书信息（只要求显示姓名和书名）
<br>
**视图的建立**

``` stylus
create view borrowInfo_C1 as
select
  c1.name as "姓名",
  bk1.name as "书名"
from
  borrow b1,
  cards c1,
  books bk1
where
  b1.cardId = c1.id
  and
  b1.bookId = bk1.id
  and
  c1.class = "计科一班"
```
<br>
















  [1]: http://www.cnblogs.com/edisonchou/p/3886801.html