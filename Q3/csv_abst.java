import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
/**
 * Used to abstract data from csv files
 * @author Raghav Tayal
 *
 */
public class csv_abst {
	int m;
	int n;
	int o;
	/**
	 * Function to abstract data from csv
	 * @param gt
	 * @param by
	 * @param gl
	 */
	void abstraction(Gift gt[], Boy by[],Girl gl[]  )
	{
		m = 0;
		String str = "";
		String File1 = "gift.csv";/**
		*Creating gift csv
		
		*/String line1 = "";
		String Splitter1 = ",";
		BufferedReader bread1 = null;
		Random rn = new Random();
		String ty[] = {"Luxury","Essential","Utility"};
		try {
			bread1 = new BufferedReader(new FileReader(File1));/**
			*Assigning attributes to gift class objects 
			*/
			while((line1 = bread1.readLine()) != null) {
				String[] gif_str = line1.split(Splitter1);
				gt[m] = new Gift();
				gt[m].name = gif_str[0];
				gt[m].price = Integer.parseInt(gif_str[1]);
				gt[m].value = Integer.parseInt(gif_str[2]);
				m++;
			}
		}
		catch(Exception e) { /**
		@exception 
		*/
			e.printStackTrace();
		}
		int i, l;
		for(i = 0; i < m; i++)
		{
			l = rn.nextInt(3);
			gt[i].type = ty[l];
		}
		File1 = "boy.csv"; /**
		Generating boy csv
		*/
		line1 = "";
		bread1 = null;
		n = 0;
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {/**
			*Assigning attributes to boy class objects
			*/
				String[] boy_str = line1.split(Splitter1);
				str = boy_str[5];
				switch(str) {//Select between types of boys
				case "Miser":
					by[n] = new Miser();
					break;
				case "Generous":
					by[n] = new Generous();
					break;
				case "Geek":
					by[n] = new Geek();
					break;
				}
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
		File1 = "girl.csv";/**
		*Generating girl csv
		*Assigning attributes to girl class objects
		*/
		line1 = "";
		bread1 = null;
		o = 0;
		try {
			bread1 = new BufferedReader(new FileReader(File1));
			while((line1 = bread1.readLine()) != null) {
				String[] girl_str = line1.split(Splitter1);
				str = girl_str[4];
				switch(str) { //Select between type of girls
				case "Choosy":
					gl[o] = new Choosy();
					break;
				case "Normal":
					gl[o] = new Normal();
					break;
				case "Desperate":
					gl[o] = new Desperate();
					break;
				}
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
