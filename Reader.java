/**
 * Reader class
 * 
 * @author ashishpateria
 *
 */
public class Reader implements Runnable {
	private int readerNum;
	private LockInterface database;
	

	public Reader(LockInterface database, int readerNum) {
		this.database = database;
		this.readerNum = readerNum;
	}

	@Override
	public void run() {

		Utilities.nap();
		System.out.println("reader " + readerNum + " wants to read.");
		database.acquireReadLock(readerNum);
		Utilities.nap();
		database.releaseReadLock(readerNum);
		

	}
	
	public String  toString(){
		return "Reader class object";
	}

}
