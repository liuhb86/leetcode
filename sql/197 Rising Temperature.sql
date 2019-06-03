# Write your MySQL query statement below
select a.Id as Id
from 
Weather a join Weather b
where a.RecordDate = date_add(b.RecordDate, interval 1 day)
and a.Temperature > b.Temperature