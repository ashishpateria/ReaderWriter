all: Cache.class compile

Cache.class:	Cache.java 
	javac *.java
	
compile: Cache.java CacheManagerDriver.java Cache.class CacheManagerDriver.class Utilities.java Utilities.class Reader.java Reader.class Writer.java Writer.class LockInterface.java LockInterface.class Logger.java Logger.class
	javac *.java

clean: rm -rf *.class
