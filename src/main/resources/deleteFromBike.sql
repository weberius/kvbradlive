delete  
from bike
where modtime <  (CURRENT_DATE - INTERVAL '14 day')