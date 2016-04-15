select 
  uid, name, bike, number, modtime, geom  
from 
  bike
where 
  number = ?
order by
  modtime desc
limit 1