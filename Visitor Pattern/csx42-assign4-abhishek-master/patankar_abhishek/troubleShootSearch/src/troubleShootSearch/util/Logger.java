package troubleShootSearch.util;

public class Logger {
	// FIXME: Add more enum values as needed for the assignment
    //public static enum DebugLevel { CONSTRUCTOR, SEARCHRESULT
                                  // };

    private static DebugLevel debugLevel;
    public static String writer= "";


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	case 4: debugLevel = DebugLevel.PRODUCTNAME; break;
	case 3: debugLevel = DebugLevel.FLOW; break;
	case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
	case 1: debugLevel = DebugLevel.SEARCHRESULT; break;
	case 0: debugLevel = DebugLevel.ERROR; break;
	default: debugLevel = null; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
    	if(levelIn == DebugLevel.SEARCHRESULT)
    		writer += message + "\n";
    	if (levelIn == debugLevel)
    		System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
}
