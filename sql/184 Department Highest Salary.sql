# Write your MySQL query statement below
select Department, Name as Employee, Salary from
Employee join (
select DepartmentId, Department.Name as Department, max(Salary) as maxSalary
    from Employee join Department on DepartmentId = Department.Id
    group by DepartmentId
) as t
where Employee.DepartmentId = t.DepartmentId and Salary = maxSalary