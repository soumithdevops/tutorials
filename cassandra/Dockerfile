DROP KEYSPACE IF EXISTS musicdb;

CREATE KEYSPACE musicdb WITH replication = 
{'class':'SimpleStrategy','replication_factor':1};

USE musicdb;

CREATE TABLE album (
	title VARCHAR,
	year INT,
	performer VARCHAR,
	genre VARCHAR,
	tracks MAP<INT,VARCHAR>,
	PRIMARY KEY ((title, year))
);
