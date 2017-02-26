import java.io.FileWriter;
import java.io.IOException;

public class logger {
	//Create log file
	void log(String s)
	{
		char buffer[] = new char[s.length()];
		s.getChars(0, s.length(),buffer,0);
		try(FileWriter f = new FileWriter("log.log")) {
			f.write(buffer);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

