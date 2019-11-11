#!/bin/bash

set -x

readonly count=$1
readonly elements=$2
readonly filename=application-arrays-"$count"-"$elements".yml

function write_array() {
  local index=$1

  if [ "$index" == 1 ]; then
    cat << EOF >> "$filename"
  - array1:
EOF
  else
    cat << EOF >> "$filename"
    array$index:
EOF
  fi

  for ((e=0; e<elements; e++)); do
    cat << EOF >> "$filename"
    - $e
EOF
  done
}

cat << EOF > "$filename"
test:
  containers:
EOF

for ((c=0; c<count; c++)); do
  for a in {1..20}; do
    write_array $a
  done
done