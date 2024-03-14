#!/bin/bash

psql -h localhost -U postgres -p 5432 -c "CREATE USER postgres WITH PASSWORD 'passwords';"
psql -h localhost -U postgres -p 5432 -c "GRANT ALL PRIVILEGES ON DATABASE usersdb TO postgres;"
