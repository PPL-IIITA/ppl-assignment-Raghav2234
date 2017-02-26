import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class ques1 {
	public static void main(String args[]) throws Exception {
		int n1;
		n1 = 0;
		boy_det by[] = new boy_det[100];
		csv.create();
		String File1 = "boy_dat.csv";
		String line1 = "";
		String Splitter1 = ",";
		BufferedReader bread1 = null;
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while ((line1 = bread1.readLine()) != null) {
				String[] boy_str = line1.split(Splitter1);
				by[n1] = new boy_det();
				by[n1].name = boy_str[0];
				by[n1].Intelligence = Integer.parseInt(boy_str[1]);
				by[n1].Attractiveness = Integer.parseInt(boy_str[2]);
				by[n1].budget = Integer.parseInt(boy_str[3]);
				by[n1].attr_req = Integer.parseInt(boy_str[4]);
				by[n1].status = Integer.parseInt(boy_str[5]);
				n1++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n2;
		n2 = 0;
		girl_det gl[] = new girl_det[100];
		String File2 = "girl_dat.csv";
		BufferedReader bread2 = null;
		try {
			bread2 = new BufferedReader(new FileReader(File2));
			while ((line1 = bread2.readLine()) != null) {
				String[] girl_str = line1.split(Splitter1);
				gl[n2] = new girl_det();
				gl[n2].name = girl_str[0];
				gl[n2].attractiveness = Integer.parseInt(girl_str[1]);
				gl[n2].intelligence = Integer.parseInt(girl_str[2]);
				gl[n2].mainten_budget = Integer.parseInt(girl_str[3]);
				n2++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int i = 0, j = 0;
		String content = "";
		for (i = 0; i < n2; i++) {
			for (j = 0; j < n1; j++) {
				if (by[j].budget >= gl[i].mainten_budget && gl[i].attractiveness >= by[j].attr_req
						&& by[j].status == 0) {
					String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss")
						.format(new Timestamp(System.currentTimeMillis()));
					content = content
						.concat(timeStamp + "  " + "Commitment : " + gl[i].name + "-" + by[j].name + " \n");
					by[j].status = 1;
					break;
				}
			}

		}
		logger l = new logger();
		l.log(content);
		System.out.println(content);
	}
}
