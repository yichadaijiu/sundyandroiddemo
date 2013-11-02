/**
 * The Sample of Javadoc 
 */
package sundy.android.demo.java4android;

/**
 * @author Administrator
 *
 */
public class JavadocSample {
	
	//1,Simple Javadoc Field Comments
	/** 
	 * Debug Tag for use logging debug output to LogCat 
	 */  
	private static final String DEBUG_TAG = "MyActivityDebugTag";  
	
	//2,Simple Javadoc Method Comments
	/** 
	 * Method that adds two integers together 
	 * 
	 * @param a The first integer to add 
	 * @param b The second integer to add 
	 * @return The resulting sum of a and b 
	 */  
	public int addIntegers(int a, int b)  
	{  
	    return (a+b);  
	}  
	
	//have return and throw exception
	/** 
	 * This method simply throws an Exception if the incoming parameter a is not a positive number, just for fun. 
	 * 
	 * @param a Whether or not to throw an exception 
	 * @throws Exception 
	 */  
	public void throwException(boolean shouldThrow) throws Exception  
	{  
	    if(shouldThrow == true)  
	    {  
	        throw new Exception();  
	    }  
	}  
}
