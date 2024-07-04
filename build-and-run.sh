#!/bin/bash

# Stop Docker Compose service
docker-compose down

# Remove Docker Compose service
docker-compose down --volumes --rmi all

# Build the service
docker-compose build

# Run the service
docker-compose up -d