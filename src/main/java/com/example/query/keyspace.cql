CREATE table emp( eid INT,
                  name TEXT,
                  department TEXT,
                  PRIMARY KEY (eid, name))
    WITH CLUSTERING ORDER BY (name DESC );