  root_directory=$(pwd)

  project_directories=("ms-cars" "ms-race" "ms-history")

for project_dir in "${project_directories[@]}"
do
  project_path="$root_directory/$project_dir"

  echo "Compiling project into $project_path"

  cd "$project_path"

  mvn package

  if [ $? -eq 0 ]; then
    echo "Build successful on $project_path"
  else
    echo "Error during compilation $project_path"
    exit 1
  fi
done

echo "Compilation of all projects completed successfully"