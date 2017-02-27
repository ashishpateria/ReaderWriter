/**
 * 
 * @author ashishpateria
 *
 */
public class Utilities {
	private static final int NAP_TIME = 5;

	public static void nap() {
		nap(NAP_TIME);
	}

	/**
	 * method send the thread to sleep to a particular duration
	 * @param duration
	 */
	public static void nap(int duration) {
		int sleeptime = (int) (NAP_TIME * Math.random());
		try {
			Thread.sleep(sleeptime * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	public String  toString(){
		return "Sleep Utilities class object";
	}

}
