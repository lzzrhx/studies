MAKEFLAGS += --no-print-directory
build+run:
	make build
	make run
build:
	mvn -quiet clean install
run:
	mvn -quiet exec:java
clean:
	mvn -quiet clean
