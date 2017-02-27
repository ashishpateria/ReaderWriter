/**
 * Reader class
 * 
 * @author ashishpateria
 *
 */
public class Reader implements Runnable {
	private int readerNum;
	private LockInterface cache;
	
	public Reader(LockInterface cache, int readerNum) {
		Logger.writeMessage("Reader Class Constructor called.", Logger.DebugLevel.CONSTRUCTOR);
		this.cache = cache;
		this.readerNum = readerNum;
	}

	@Override
	public void run() {

		Utilities.nap();
		System.out.println(readerNum + " Reader wants to read from the cache.");
		cache.acquireReadLock(readerNum);
		Utilities.nap();
		cache.releaseReadLock(readerNum);
		

	}
	
	/**
	 * to string method for Reader Class
	 */
	public String  toString(){
		return "Reader class object";
	}

}
