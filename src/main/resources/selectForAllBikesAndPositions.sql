select 
  uid, name, bike, number, modtime, ST_X(geom) lat, st_y(geom) lng
from 
  bike
order by
  number, modtime
