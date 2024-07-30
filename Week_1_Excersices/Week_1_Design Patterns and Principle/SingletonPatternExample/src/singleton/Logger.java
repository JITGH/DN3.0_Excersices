package singleton;

public class Logger {
	// Step 1: Create a private static instance of the Logger class
	private static Logger loggersetInstance=null;
	
	private Logger() {
	//Step 2:  Private constructor to prevent instantiation
	}
	// Step 3: Provide a public static method to get the instance of the Logger class
    public static Logger getInstance() {
        if (loggersetInstance == null) {
        	loggersetInstance = new Logger();
        }
        return loggersetInstance;
    }
    
    // Example logging method
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
