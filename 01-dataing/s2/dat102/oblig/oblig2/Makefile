MAKEFLAGS += --no-print-directory
mvn-build+run:
	make mvn-build
	make mvn-run
mvn-build:
	mvn -quiet clean install
mvn-run:
	mvn -quiet exec:java
mvn-clean:
	mvn -quiet clean
build+run:
	make build
	make run
build:
	javac -encoding utf8 ./src/*.java
run:
	java src.Program
clean:
	rm ./src/*.class

