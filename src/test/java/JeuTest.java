import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

public class JeuTest {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println("truc");


	}
	*/
	
	@BeforeTest
	public void setup (){
		
	}
	
	@Test
	@Parameters({"mot"})
	public void jeutest(String mot){
		assertEquals("OK", mot);
		System.out.println("tester");
	}

}
