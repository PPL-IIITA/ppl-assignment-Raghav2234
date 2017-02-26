import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class csv {
	static void create()
	{
		String content = "";
		Random rn = new Random();
		int i;
		for(i = 0; i < 10; i++)
		{
			content = content.concat("boy"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(10000)+","+rn.nextInt(10)+","+"0"+"\n");
		}
		char[] buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("boy_dat.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
		content = "";
		for(i = 0; i < 5; i++)
		{
			content = content.concat("girl"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(10000)+"\n");
		}
		buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("girl_dat.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
