-- selectiert alle bikes die sich nach dem zeitpunkt veraendert haben 
select 
  uid, name, bike, number, modtime, ST_X(geom) lat, st_y(geom) lng
from 
  bike
where 
  number in (
    select distinct number
    from bike
    where modtime > ?
  )
order by
  number, modtime desc
