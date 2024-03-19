#!/bin/bash

# Function to rename a directory if it exists
rename_dir() {
  from_dir="$1"
  to_dir="$2"

  if [[ -d "$from_dir" ]]; then
    echo "Renaming directory: $from_dir -> $to_dir"
    mv "$from_dir" "$to_dir"
  fi
}

# Rename directories (replace "old_dir1" and "old_dir2" with your actual directory names)
rename_dir "db_primary_example" "db_primary"
rename_dir "db_secondary_example" "db_secondary"

# Run docker-compose up -d
docker-compose up -d
