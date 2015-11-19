select 
  uid, name, bike, number, modtime, geom
from 
  bike
where 
  modtime > ?
order by
  number, modtime desc
;
