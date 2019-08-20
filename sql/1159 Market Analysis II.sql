/* Write your PL/SQL query statement below */
/* copied */
select u.user_id "seller_id", (case when u.favorite_brand=i.item_brand then 'yes' else 'no' end) "2nd_item_fav_brand" 
from users u left join 
(select * from (
select seller_id, item_id, rank() over(partition by seller_id order by order_date) r
from orders) t where t.r=2) t1 on u.user_id = t1.seller_id
left join items i on t1.item_id = i.item_id order by u.user_id