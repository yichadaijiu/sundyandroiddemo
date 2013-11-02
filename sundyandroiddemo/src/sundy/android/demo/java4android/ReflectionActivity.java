/**
 * @author Sundy
 * @description reflection demo
 */
package sundy.android.demo.java4android;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Administrator
 *
 */
public class ReflectionActivity extends Activity {

	private Class classToInvestigate  ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//1,Inspecting Classes
		String sClassName = "android.app.NotificationManager";  
		try {  
			classToInvestigate = Class.forName(sClassName);   
			
		    // Dynamically do stuff with this class  
		    // List constructors, fields, methods, etc.  
		  
		} catch (ClassNotFoundException e) {  
		    // Class not found!  
		} catch (Exception e) {  
		    // Unknown exception  
		}  
		
		
		
		//2,Inspecting the Constructors Available Within a Class
		Constructor[] aClassConstructors = classToInvestigate.getDeclaredConstructors();  
		for(Constructor c : aClassConstructors){  
		    // Found a constructor c  
		}
		
		//3,Inspecting the Fields Available Within a Class
		Field[] aClassFields = classToInvestigate.getDeclaredFields();  
		for(Field f : aClassFields){  
		    // Found a field f  
		}  
		
		//2nd of 3
		sClassName = "android.content.Intent";  
		try {  
		    classToInvestigate = Class.forName(sClassName);  
		    String strNewFieldName = "EXTRA_CHANGED_PACKAGE_LIST";  
		    Field newIn22 = classToInvestigate.getField(strNewFieldName);  
		  
		} catch (ClassNotFoundException e) {  
		    // Class not found  
		} catch (NoSuchFieldException e) {  
		    // Field does not exist, likely we are on Android 2.1 or older  
		    // provide alternative functionality to support older devices  
		} catch (SecurityException e) {  
		    // Access denied!  
		} catch (Exception e) {  
		    // Unknown exception  
		}  
		
		//4,Inspecting the Methods Available Within a Class
		Method[] aClassMethods = classToInvestigate.getDeclaredMethods();  
		for(Method m : aClassMethods)  
		{  
		    // Found a method m  
		}  
		
		//5,Inspecting Inner Classes  ; Inspecting Member Modifiers
		int permissions = classToInvestigate.getModifiers();  
		  
		if(Modifier.isPublic(permissions)) {  
		    // Class is Public  
		}  
		if(Modifier.isProtected(permissions)) {  
		    // Class is Protected  
		}  
		if(Modifier.isPrivate(permissions)) {  
		    // Class is Private  
		}  
		
		//6,Inspecting Class Metadata(annotations)
		sClassName = "android.widget.AbsoluteLayout";  
		try {  
		    classToInvestigate = Class.forName(sClassName);  
		  
		    Annotation[] aAnnotations = classToInvestigate.getDeclaredAnnotations();  
		    for(Annotation a : aAnnotations)  
		    {  
		        // Found an annotation, use a.toString() to print it out  
		    }  
		  
		} catch (ClassNotFoundException e) {  
		    // Class not found!  
		} catch (Exception e) {  
		    // Handle unknown exception!  
		}  
		

	}

}
