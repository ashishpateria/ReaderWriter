
public class CacheManagerDriver {

	public static int NUM_OF_READERS;
	public static int NUM_OF_WRITERS;

	public static void main(String args[]) {

		if (args.length != 2) {
			System.out.println("Please enter No.of Readers and No.of Writers ");
			System.out.println("Usage: Readers Writers");
			System.exit(1);
		}

		LockInterface cache = new Cache();

		NUM_OF_READERS = Integer.parseInt(args[0]);
		NUM_OF_WRITERS = Integer.parseInt(args[1]);
		Thread[] readerArray = new Thread[NUM_OF_READERS];
		Thread[] writerArray = new Thread[NUM_OF_WRITERS];

		for (int i = 0; i < NUM_OF_READERS; i++) {
			readerArray[i] = new Thread(new Reader(cache, i));
			readerArray[i].start();
		}

		for (int i = 0; i < NUM_OF_WRITERS; i++) {
			writerArray[i] = new Thread(new Writer(cache, i));
			writerArray[i].start();
		}

	}
	
	public String  toString(){
		return "Cache manager Driver class object";
	}

}
