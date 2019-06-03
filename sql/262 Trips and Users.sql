# Write your MySQL query statement below
select Request_at as Day, round(sum(if(Status = 'completed', 0, 1)) / count(Id), 2) as `Cancellation Rate`
from Trips join Users u1 join Users u2
where 
Client_Id = u1.Users_Id and u1.Banned = 'No'
and Driver_Id = u2.Users_Id  and u2.Banned = 'No'
and Request_at between '2013-10-01' and '2013-10-03'
group by Day