import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataTest {

	public void dataestToDo () throws InvalidFormatException, IOException{

		// lecture du fichier excel et creation de la liste de tests qui est "include"
		final File file = new File("C:/Program Files (x86)/Jenkins/workspace/test/data.xlsx");
		final Workbook workbook = WorkbookFactory.create(file);
		final Sheet sheet = workbook.getSheet("Feuil1");

		int index = 0;
		ArrayList listetests = new ArrayList ();
		Row row = sheet.getRow(index);

		while (row != null) {
			if (row.getCell(1).toString().equals("include")){
				listetests.add(row.getCell(0));
			}
			index+=1;
			row = sheet.getRow(index);
		}

		//System.out.println(listetests);

		//creation du fichier xml


		XmlSuite suite = new XmlSuite();
		suite.setName("TestJenkins");

		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("JeuTest"));

		XmlTest test = new XmlTest(suite);
		test.setName("TestJenkins");
		test.setXmlClasses(classes);

		List<XmlInclude> methods = new ArrayList<XmlInclude>();

		for (int i=0; i<listetests.size();i++){
			methods.add(new XmlInclude(listetests.get(i).toString()));
		}

		classes.get(0).setIncludedMethods(methods);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		TestNG testNG = new TestNG();
		testNG.setXmlSuites(suites);
		testNG.run();
	}

}
