#!/bin/bash

set -x

readonly count=$1
readonly elements=$2
readonly filename=application-arrays-"$count"-"$elements".yml

readonly field_names=('names' 'types' 'orgs' 'spaces' 'kinds' 'namespaces' 'versions' 'permissions' 'usernames' 'passwords' )

function write_array() {
  local index=$1
  local name=$2

  if [ "$index" == 0 ]; then
    cat << EOF >> "$filename"
  - $name:
EOF
  else
    cat << EOF >> "$filename"
    $name:
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
  for a in {0..9}; do
    write_array "$a" "${field_names[a]}"
  done
done