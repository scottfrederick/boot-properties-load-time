#!/bin/bash

set -x

readonly count=$1
readonly filename=application-primitives-"$count".yml

cat << EOF > "$filename"
test:
  containers:
EOF

for ((c=0; c<count; c++)); do

  cat << EOF >> "$filename"
  - string1: value1
EOF

  for s in {2..20}; do
    cat << EOF >> "$filename"
    string$s: value$s
EOF
  done

  for i in {1..20}; do
    cat << EOF >> "$filename"
    integer$i: $i
EOF
  done
done