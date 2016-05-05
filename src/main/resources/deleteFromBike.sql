delete  
from bike
where modtime <  (CURRENT_DATE - INTERVAL '30 day')