# Write your MySQL query statement below
select user_id as buyer_id, join_date, count(order_id) as orders_in_2019
from Users left outer join 
(select * from Orders 
 where order_date >= '2019-01-01' and order_date <= '2019-12-31') as t 
on user_id = buyer_id
group by user_id, join_date