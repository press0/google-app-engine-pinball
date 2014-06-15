pinball
=======

command-line:
mvn -f pom-cli.xml clean install
java -jar target/pinball.jar

GAE:
mvn clean install
deploy pinball-gae.war to GAE

http://pinballgae.appspot.com/
