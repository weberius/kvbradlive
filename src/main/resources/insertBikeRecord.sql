INSERT INTO 
BIKE (uid,name,bike,number,geom) 
VALUES (?,?,?,?,ST_SetSRID(ST_POINT(?,?), 4326))
--VALUES (?,?,?,?,ST_POINT(?,?))