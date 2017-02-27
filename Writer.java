
public class Writer implements Runnable {

	private LockInterface database;
	private int writerNum;

	public Writer(LockInterface d, int w) {
		writerNum = w;
		database = d;
	}

	@Override
	public void run() {
		
		Utilities.nap();
		System.out.println("writer " + writerNum + " wants to write.");

		database.acquireWriteLock(writerNum);
		Utilities.nap();
		database.releaseWriteLock(writerNum);

		

	}
	
	public String  toString(){
		return "Writer class object";
	}

}
