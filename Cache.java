import java.util.concurrent.Semaphore;

/**
 * Cache class to support multiple readers and writers
 * 
 * @author ashishpateria
 *
 */
public class Cache implements LockInterface {

	private int readerCount;
	private Semaphore mutex;
	private Semaphore cache;

	/**
	 *Constructor to initialize readercount and semaphores 
	 */
	public Cache() {
		readerCount = 0;
		//Semaphore used as a lock for accessing the cache efficiently. 
		cache = new Semaphore(1);
		//Semaphore as lock for accessing the number of readers update 
		mutex = new Semaphore(1);
		
	}

	/**
	 * Method to acquire read lock for reading
	 * @param number of readers
	 * 
	 */
	@Override
	public void acquireReadLock(int readerNum) {

		try {
				mutex.acquire();
				
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		++readerCount;
		if (readerCount == 1) {
			try {
				cache.acquire();
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println(readerNum + " ReaderThread is reading the cache.");
		mutex.release();
	}

	@Override
	public void releaseReadLock(int readerNum) {
		try {
			mutex.acquire();

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		--readerCount;
		if (readerCount == 0) {
			cache.release();
		}
		
		System.out.println(readerNum + " ReaderThread is done reading the cache.");
		mutex.release();
	}

	@Override
	public void acquireWriteLock(int writerNum) {
		try {
			mutex.acquire();
			if(readerCount>0){
				mutex.release();
				Utilities.nap();
			}
			cache.acquire();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println( writerNum + " WriterThread is writing the cache.");
		
	}

	@Override
	public void releaseWriteLock(int writerNum) {

		System.out.println(writerNum + " WriterThread is done writing the cache.");
		cache.release();

	}
	
	public String  toString(){
		return "Cache class object";
	}
}
