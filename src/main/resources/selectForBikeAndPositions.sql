select 
  uid, name, bike, number, modtime, geom
from 
  bike
where 
  number = ?
order by
  modtime
;