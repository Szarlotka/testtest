import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Before {
	
	public void beforetest () throws InvalidFormatException, IOException {
		DataTest data = new DataTest();
		data.dataestToDo();
	}
}
