# ReaderWriter
Simple Reader Writer program in JAVA with Semaphore as lock.


Running Test Cases:
the program run with 2 arguments NoofReaders NoofWriters
remote07:~> make
javac *.java





remote07:~> java CacheManagerDriver 3 2
0 Reader wants to read from the cache.
writer 0 wants to write.
0 ReaderThread is reading the cache.
0 ReaderThread is done reading the cache.
2 Reader wants to read from the cache.
2 ReaderThread is reading the cache.
1 Reader wants to read from the cache.
1 ReaderThread is reading the cache.
writer 1 wants to write.
2 ReaderThread is done reading the cache.
1 ReaderThread is done reading the cache.
1 WriterThread is writing the cache.
1 WriterThread is done writing the cache.
0 WriterThread is writing the cache.
0 WriterThread is done writing the cache.

