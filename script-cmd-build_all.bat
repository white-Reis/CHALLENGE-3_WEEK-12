@echo off
setlocal enabledelayedexpansion

set "root_directory=%CD%"
set "project_directories=ms-cars ms-race ms-history"

for %%d in (%project_directories%) do (
  set "project_path=!root_directory!\%%d"
  echo Compiling project into !project_path!
  pushd "!project_path!"
  call mvn package -Dmaven.test.skip=true -DoutputDirectory=target
  popd
)

echo Compilation of all projects completed successfully
exit /b 0