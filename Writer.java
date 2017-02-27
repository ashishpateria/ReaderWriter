/**
 * Writer class
 * @author ashishpateria
 *
 */
public class Writer implements Runnable {

	private LockInterface cache;
	private int writerNum;

	public Writer(LockInterface d, int w) {
		Logger.writeMessage("Writer Class Constructor called.", Logger.DebugLevel.CONSTRUCTOR);
		writerNum = w;
		cache = d;
	}

	@Override
	public void run() {
		
		Utilities.nap();
		System.out.println("writer " + writerNum + " wants to write.");

		cache.acquireWriteLock(writerNum);
		Utilities.nap();
		cache.releaseWriteLock(writerNum);

		

	}
	/**
	 * to string method
	 */
	public String  toString(){
		return "Writer class object";
	}

}
