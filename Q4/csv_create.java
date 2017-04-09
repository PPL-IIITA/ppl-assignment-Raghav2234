import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * <h6>Create csv file for gift,boy and girl class</h6>
 * @author Raghav Tayal
 *
 */
public class csv_create {
	static void log()
	{
		String content = "";
		Random rn = new Random();
		int i, j = 0;
		for(i = 0; i < 15; i++)
		{
			content = content.concat("Gift"+i+","+rn.nextInt(300)+","+rn.nextInt(50)+","+"-1"+","+"-1"+","+"-1"+"\n");
		}
		char[] buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("gift.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
		content = "";
		String s[] = {"Miser","Generous","Geek"};
		for(i = 0; i < 20; i++)
		{
			j = rn.nextInt(3);
			content = content.concat("Boy"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(1000)+","+"0"+","+s[j]+"\n");
		}
		buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("boy.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
		content = "";
		String s1[] = {"Choosy","Normal","Desperate"};
		for(i = 0; i < 10; i++)
		{
			j = rn.nextInt(3);
			content = content.concat("Girl"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(1000)+","+s1[j]+","+"0"+"\n");
		}
		buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("girl.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
