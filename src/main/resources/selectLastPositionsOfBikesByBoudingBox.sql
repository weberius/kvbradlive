select A.uid, A.name, A.bike, A.number, A.modtime, ST_X(A.geom) lat, st_y(A.geom) lng 
from bike as A 
  inner join (
    select number, max(modtime) as modtime 
      from bike group by number
    ) as B on A.number = B.number and A.modtime = B.modtime
WHERE geom && ST_MakeEnvelope(?, ?, ?, ?, ?)