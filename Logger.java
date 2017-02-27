public class Logger{

	public Logger(){
			Logger.writeMessage("Logger Class Constructor called.", DebugLevel.CONSTRUCTOR);
	}
	
	
    public static enum DebugLevel { CONSTRUCTOR,NOOUTPUT, RESULT,RUN
                                   };

    private static DebugLevel debugLevel;

    /**
     *sets debug levels for different debug values. 
     * @param levelIn
     */
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 0: debugLevel = DebugLevel.NOOUTPUT;break;
    		case 1: debugLevel = DebugLevel.RUN;break;
    		case 2: debugLevel = DebugLevel.RESULT;break;	
    		case 3: debugLevel = DebugLevel.CONSTRUCTOR; break;
    	}
    }
    
    /**
     * 
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    /**
     * writes message to screen based to the debug value.
     * @param message
     * @param levelIn
     */
    public static void writeMessage (String message ,DebugLevel levelIn ) {
    	if (levelIn == debugLevel)
	    System.out.println(message);
    }
    
    /**
     * Logger toString method 
     */
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}