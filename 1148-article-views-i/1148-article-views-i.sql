# Write your MySQL query statement below
Select DISTINCT author_id AS id
From views 
where author_id = viewer_id
Order by author_id ASC;