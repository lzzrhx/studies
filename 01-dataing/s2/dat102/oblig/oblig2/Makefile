MAKEFLAGS += --no-print-directory
build+run-mvn:
	make build-mvn
	make run-mvn
build-mvn:
	mvn -quiet clean install
run-mvn:
	mvn -quiet exec:java
build+run:
	make build
	make run
build:
	javac -encoding utf8 ./src/*.java
run:
	java src.Program
clean:
	rm ./*.class

