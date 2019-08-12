# Write your MySQL query statement below
select distinct id
from (
select viewer_id as id, view_date, count(distinct article_id)
    from Views
    group by viewer_id, view_date
    having count(distinct article_id) > 1
) t
order by id