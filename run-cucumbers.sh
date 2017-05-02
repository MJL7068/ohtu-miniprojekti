#!/bin/bash

REPO_NAME="ohtu-miniprojekti-integrationTest"
git clone "https://github.com/MJL7068/$REPO_NAME"
./gradlew assemble
./gradlew run &
cd $REPO_NAME
./gradlew assemble
sleep 30
./gradlew check -i
EXIT_STATUS=$?
cd ..
kill -9 $!
rm -rf $REPO_NAME
exit "$EXIT_STATUS"
