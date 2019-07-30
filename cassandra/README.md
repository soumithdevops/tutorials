Create db and table from CQL :-
cqlsh -f cql/musicdata.cql

Add data to tables :-
COPY album (title,year,performer,genre,tracks) FROM 'album.csv' WITH HEADER=true;


