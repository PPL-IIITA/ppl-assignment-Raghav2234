import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class csv_q2 {
	static void log()
	{
		String content = "";
		Random rn = new Random();
		int i, j = 0;
		//Creating content for gift csv 
		for(i = 0; i < 15; i++)
		{
			content = content.concat("Gift"+i+","+rn.nextInt(4000)+","+rn.nextInt(2000)+","+"-1"+","+"-1"+","+"-1"+"\n");
		}
		//Creating csv file for gifts
		char[] buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("gift.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
		content = "";
		String s[] = {"Miser","Generous","Geek"};
		//Creating content for boys csv
		for(i = 0; i < 20; i++)
		{
			j = rn.nextInt(3);
			content = content.concat("Boy"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(10000)+","+"0"+","+s[j]+"\n");
		}
		//Creating csv file for boys
		buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("boy.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
		content = "";
		String s1[] = {"Choosy","Normal","Desperate"};
		//Creating content for gift csv
		for(i = 0; i < 10; i++)
		{
			j = rn.nextInt(3);
			content = content.concat("Girl"+i+","+rn.nextInt(10)+","+rn.nextInt(10)+","+rn.nextInt(10000)+","+s1[j]+"\n");
		}
		//Creating csv for girls
		buf = new char[content.length()];
		content.getChars(0, content.length(), buf, 0);
		try(FileWriter f = new FileWriter("girl.csv")) {
			f.write(buf);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

