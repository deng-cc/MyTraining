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




















  [1]: http://www.cnblogs.com/edisonchou/p/3886801.html