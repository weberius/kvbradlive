CREATE TABLE bike (
    uid          integer,
    name         varchar(256),
    bike         integer DEFAULT 0,
    number       integer NOT NULL,
    modtime      timestamp DEFAULT current_timestamp
);
SELECT AddGeometryColumn ('public','bike','geom',4326,'POINT',2);

CREATE TABLE kvbradlive (
    numberofinsert integer,
    modtime      timestamp DEFAULT current_timestamp
);
