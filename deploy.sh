#/bin/sh

rm deps-ancient.jar 2>&1 > /dev/null

clj -A:jar &&                                             \
clj -Spom &&                                              \
mvn deploy:deploy-file -Dfile=deps-ancient.jar            \
    -DrepositoryId=clojars -Durl=https://clojars.org/repo \
    -DpomFile=pom.xml
