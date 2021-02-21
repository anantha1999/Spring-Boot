initdb -D /usr/local/var/postgres/microservice1
initdb -D /usr/local/var/postgres/microservice2
pg_ctl -D /usr/local/var/postgres/microservice1 -o "-p 5434" start
pg_ctl -D /usr/local/var/postgres/microservice2 -o "-p 5433" start
