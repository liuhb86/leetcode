# Write your MySQL query statement below
select t.Name as Employee from
Employee as t inner join Employee as s on t.ManagerId = s.Id
where t.Salary > s.Salary