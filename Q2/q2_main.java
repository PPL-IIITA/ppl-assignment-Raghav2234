import java.io.*;
import java.util.Random;
public class q2_main {
	public static void main(String args[]){
		int g1 ;
		g1 = 0;
		csv_q2.log();//Creating csv file
		Gift gt[] = new Gift[100];
		String File1 = "gift.csv";
		String line1 = "";
		String Splitter1 = ",";
		BufferedReader bread1 = null;
		Random rn = new Random();
		String ty[] = {"Luxury","Essential","Utility"};
		// Getting content from csv for gift
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {
				String[] gif_str = line1.split(Splitter1);
				gt[g1] = new Gift();
				gt[g1].name = gif_str[0];
				gt[g1].price = Integer.parseInt(gif_str[1]);
				gt[g1].value = Integer.parseInt(gif_str[2]);
				gt[g1].diff_ob = Integer.parseInt(gif_str[3]);
				gt[g1].Lux_rat  = Integer.parseInt(gif_str[4]);
				gt[g1].uti_val = Integer.parseInt(gif_str[5]);
				g1++;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		int i, l;
		for(i = 0; i < g1; i++)
		{
			l = rn.nextInt(3);
			gt[i].type = ty[l];
		}
		for(i = 0; i < g1; i++)
		{
			if((gt[i].type).equals(ty[0])) {
				gt[i].Lux_rat = rn.nextInt(10);
				gt[i].diff_ob = rn.nextInt(10);
			}
			else if((gt[i].type).equals(ty[2])) {
				gt[i].uti_val = rn.nextInt(10);
			}
		}
		Boy_2 by[] = new Boy_2[100];
		File1 = "boy.csv";
		line1 = "";
		bread1 = null;
		int b1 = 0;
		try {
			//Getting content from csv for boys
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {
				String[] boy_str = line1.split(Splitter1);
				by[b1] = new Boy_2();
				by[b1].name = boy_str[0];
				by[b1].Intelligence = Integer.parseInt(boy_str[1]);
				by[b1].Attractiveness = Integer.parseInt(boy_str[2]);
				by[b1].budget = Integer.parseInt(boy_str[3]);
				by[b1].status  = Integer.parseInt(boy_str[4]);
				by[b1].type = boy_str[5];
				b1++;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		Girl_2 gl[] = new Girl_2[100];
		File1 = "girl.csv";
		line1 = "";
		bread1 = null;
		int g = 0;
		try {
			//Getting content from csv for girls
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine())!= null) {
				String[] girl_str = line1.split(Splitter1);
				gl[g] = new Girl_2();
				gl[g].name = girl_str[0];
				gl[g].Intelligence = Integer.parseInt(girl_str[1]);
				gl[g].Attractiveness = Integer.parseInt(girl_str[2]);
				gl[g].maint_budg = Integer.parseInt(girl_str[3]);
				gl[g].type = girl_str[4];
				g++;
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		int j;
		Gift temp;	
		for(i = 0; i < g1; i++)
		{
			for(j = i+1; j < g1; j++)
			{
				if(gt[i].price > gt[j].price) {
					temp = gt[i];
					gt[i] = gt[j];
					gt[j] = temp;
				}
			}
		}
		//Calling create from couple class to form couples
		Couple c = new Couple();
		c.create(gt, g1, by, b1, gl, g);
	}
}
