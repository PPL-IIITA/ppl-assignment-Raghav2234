/**
 * @author Raghav Tayal
 * Create log files
 */
import java.io.*;
public class Logger {
		void log(String s)
		{
			char buffer[] = new char[s.length()];
			s.getChars(0, s.length(),buffer,0);
			/**
			 * @exception
			 */
			try(FileWriter f = new FileWriter("log.log")) {
				f.write(buffer);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}

