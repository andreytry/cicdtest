package pega.ui.unittest.headless;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class PegaUIUnitTest {
	public static String targetURL; // = "http://127.0.0.1:9090/prweb";
   
	public static void main(String[] args) {		
		if (args.length > 0) {
			targetURL = args[0];
		}
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setVerbose(10);
		testng.setTestClasses(new Class[] {UserLogin.class });
		testng.addListener(tla);
		testng.run();		 
	}
}
