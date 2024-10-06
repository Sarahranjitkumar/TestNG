package Testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pages.loginpage;

@Listeners( Listener.class)
public class LoginTest extends BaseClass{
	
	@Test(groups = {"sanity"},description="Login Failiure Test")
	public void TC01_LoginFailureTest() {
		
		loginpage lp = new loginpage();
		lp.LoginFunction("abc@xyz.com", "Abcd@1234");
		lp.ValidateErrorMsg("The email or password you have entered is invalid");
		
	}
	
	@Test(groups = {"sanity"},description="Login Success Test")
	public void TC02_LoginSuccessTest() {
		
		loginpage lp = new loginpage();
		lp.LoginFunction("pqr@xyz.com", "Correct@1234");
		
	}
	
	
	@Test
	@Parameters({"param1","param2"})
	public void TC03_LoginSuccessTest(String Uname, String Pwd) {
		
		loginpage lp = new loginpage();
		lp.LoginFunction(Uname, Pwd);
		
	}
	
Map<String, String> testdata = new HashMap<String, String>();
	
	
	@Test(dataProvider="dp")
	public void TC04_LoginSuccessTest(String key) {
		
		loginpage lp = new loginpage();
		lp.LoginFunction(key, testdata.get(key));
		
	}
	@Test
       public void TC05_LoginFailureTest() {
		
		loginpage lp = new loginpage();
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		lp.LoginFunction(UserNameVal, PasswordVal);
		lp.ValidateErrorMsg("The email or password you have entered is invalid.");
			
		
	}



	
	
	@DataProvider(name = "dp")
	public Iterator<String> method1() {
		
		testdata.put("aaa@xyz.com", "Abc@1234");
		testdata.put("bbb@xyz.com", "Abc@1234");
		testdata.put("ccc@xyz.com", "Abc@1234");
		testdata.put("jeera@imk.com", "Nali@456");
		
		return testdata.keySet().iterator();
		
	}


	
	
	
	
	
	
	
	
	
	


	

}
