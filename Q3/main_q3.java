import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
/**The main class of the program
 * 
 * @author Raghav Tayal
 *
 */
public class main_q3 {
		public static void main(String args[])
		{
			csv_create.log();
			Gift gt[] = new Gift[100];
			Boy by[] = new Boy[100];
			Girl gl[] = new Girl[100];
			csv_abst l = new csv_abst();/**
			*Abstracting data from log files and putting them into objects
			*/
			l.abstraction(gt, by, gl);
			int g1 = l.m, b1 = l.n,gl1 = l.o;
			int i, j, k = 0;
			Gift temp;	
			for(i = 0; i < g1; i++)/**
			Sorting gifts according to price
			*/
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
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			String content ="";
			Couple cp[] = new Couple[50];/**
			Creating instances of couple class
			/**
			 * Making commitments
			 */
			for(i = 0; i < gl1 ; i++)
			{
				for(j = 0 ; j < b1; j++)
				{
					if(by[j].status == 0 && gl[i].Status == 0 && by[j].budget >= gl[i].maint_budg && gl[i].Attractiveness >= by[j].att_req) {
							
							by[j].status = 1;
							gl[i].Status = 1;
							content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" \n\n");//New couple formed after making commitments
							cp[k] = new Couple(by[j], gl[i], gt, g1);
							k++;
					}
				}
			}
			double happiness[] = new double[50];
			int compatibility[] = new int[50];
			/**
			 * Sorting couples according to happiness
			 */
			for(i =0 ; i < k ; i++)
			{
				happiness[i] = cp[i].Happiness();
				compatibility[i] = cp[i].compatibility();
			}
			Couple c;
			for(i = 0; i < k  - 1 ;i++) 
			{
				for(j = i + 1; j < k; j++)
				{
					if(happiness[i] < happiness[j]) {
						c = cp[i];
						cp[i] = cp[j];
						cp[j] = c;
					}
				}
			}
			Random rn = new Random();
			int n = rn.nextInt(k);
			content = content.concat(timeStamp+" "+"List of " +n+" happiest couples"+"\n\n");
			for(i = 0; i < n; i++)
			{
				content = content.concat("\n"+timeStamp+ " "+i+". "+cp[i].girl.name +"-"+cp[i].boy.name+" \n\n");
			}
			/**
			 * Sorting according to campatibility
			 */
			for(i = 0; i < k  - 1 ;i++) 
			{
				for(j = i + 1; j < k; j++)
				{
					if(compatibility[i] < compatibility[j]) {
						c = cp[i];
						cp[i] = cp[j];
						cp[j] = c;
					}
				}
			}
			content = content.concat(timeStamp+" "+"List of "+n+" most compatible couples"+"\n\n");
			for(i = 0; i < n; i++)
			{
				content = content.concat("\n"+timeStamp+ " "+i+". "+cp[i].girl.name +"-"+cp[i].boy.name+" \n\n");
			}
			Logger lg = new Logger();
			lg.log(content);
			System.out.println(content);
		}
}
