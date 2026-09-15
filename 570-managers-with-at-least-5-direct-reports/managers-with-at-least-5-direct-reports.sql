# Write your MySQL query statement below
select m.name from Employee e
join Employee m on e.managerId=m.id
group by m.name ,m.id
having count(e.id)>=5;

