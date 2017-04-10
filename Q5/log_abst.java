import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
/**
 * Used to abstract data from logger utility
 * @author Raghav Tayal
 *
 */
public class log_abst {
	int m;
	int n;
	int o;
	void abstraction(Gift gt[], Boy by[],Girl gl[]  )
	{
		m = 0;
		String File1 = "gift.csv";//Creating gift csv
		String line1 = "";
		String Splitter1 = ",";
		BufferedReader bread1 = null;
		Random rn = new Random();//Using random class
		String ty[] = {"Luxury","Essential","Utility"};
		try {
			bread1 = new BufferedReader(new FileReader(File1));//Assigning attributes to gift class objects 
			while((line1 = bread1.readLine()) != null) {
				String[] gif_str = line1.split(Splitter1);
				gt[m] = new Gift();
				gt[m].name = gif_str[0];
				gt[m].price = Integer.parseInt(gif_str[1]);
				gt[m].value = Integer.parseInt(gif_str[2]);
				gt[m].diff_ob = Integer.parseInt(gif_str[3]);
				gt[m].Lux_rat  = Integer.parseInt(gif_str[4]);
				gt[m].uti_val = Integer.parseInt(gif_str[5]);
				m++;
			}
		}
		catch(Exception e) { //Using exception
			e.printStackTrace();
		}
		int i, l;
		for(i = 0; i < m; i++)
		{
			l = rn.nextInt(3);
			gt[i].type = ty[l];
		}
		for(i = 0; i < m; i++)
		{
			if((gt[i].type).equals(ty[0])) {
				gt[i].Lux_rat = rn.nextInt(10);
				gt[i].diff_ob = rn.nextInt(10);
			}
			else if((gt[i].type).equals(ty[2])) {
				gt[i].uti_val = rn.nextInt(10);
			}
		}
		File1 = "boy.csv"; //Generating boy csv
		line1 = "";
		bread1 = null;
		n = 0;
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {//Assigning attributes to boy class objects
				String[] boy_str = line1.split(Splitter1);
				by[n] = new Boy();
				by[n].name = boy_str[0];
				by[n].Intelligence = Integer.parseInt(boy_str[1]);
				by[n].Attractiveness = Integer.parseInt(boy_str[2]);
				by[n].budget = Integer.parseInt(boy_str[3]);
				by[n].status = Integer.parseInt(boy_str[4]);
				by[n].type = boy_str[5];
				n++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		File1 = "girl.csv";//Generating girl csv
		line1 = "";
		bread1 = null;
		o = 0;
		//Assigning attributes to girl class objects
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {
				String[] girl_str = line1.split(Splitter1);
				gl[o] = new Girl();
				gl[o].name = girl_str[0];
				gl[o].Intelligence = Integer.parseInt(girl_str[1]);
				gl[o].Attractiveness = Integer.parseInt(girl_str[2]);
				gl[o].maint_budg = Integer.parseInt(girl_str[3]);
				gl[o].type = girl_str[4];
				gl[o].Status = Integer.parseInt(girl_str[5]);
				o++;
			}
		}catch(Exception e) {
				e.printStackTrace();
		}
	}
}
