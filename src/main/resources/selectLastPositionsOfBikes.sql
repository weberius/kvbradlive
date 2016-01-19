select A.uid, A.name, A.bike, A.number, A.modtime, A.geom 
from bike as A 
  inner join (
    select number, max(modtime) as modtime 
      from bike group by number
    ) as B on A.number = B.number and A.modtime = B.modtime