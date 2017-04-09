import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
/**
 * main class of the program
 * @author Raghav Tayal
 *
 */
public class main_4 {
	public static void main(String ar[]) {
		csv_create.log(); /**
		*generating csv file
		*/
		Gift gt[] = new Gift[100];
		Boy by[] = new Boy[100];
		Girl gl[] = new Girl[100];
		log_abst l = new log_abst();/**
		*Abstracting data from log files and putting that into objects
		*/
		l.abstraction(gt, by, gl);
		int g1 = l.m, b1 = l.n,gl1 = l.o;
		int i, j, k = 0;
		Gift temp;	
		for(i = 0; i < g1; i++)/**
		*Sorting gifts according to price
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
		String content ="";
		Couple cp[] = new Couple[50];//Creating instances of couple class
		//Making commitments
		for(i = 0; i < gl1 ; i++)
		{
			for(j = 0 ; j < b1; j++)
			{
				if(by[j].status == 0 && gl[i].Status == 0 && by[j].budget >= gl[i].maint_budg && gl[i].Attractiveness >= by[j].att_req) {
						
						by[j].status = 1;
						gl[i].Status = 1;
						String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
						content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" \n\n");//New couple formed
						cp[k] = new Couple(by[j], gl[i], gt, g1);
						k++;
				}
			}
		}
		for(i = 0 ; i < k ; i++)/**
		*Calculating couple happiness
		*/
			cp[i].Happiness();
		Couple c;
		for(i = 0; i < k  - 1 ;i++) 
		{
			for(j = i + 1; j < k; j++)
			{
				if(cp[i].hap > cp[j].hap) {
					c = cp[i];
					cp[i] = cp[j];
					cp[j] = c;
				}
			}
		}
		int n;
		Random rn = new Random();
		n = rn.nextInt(k);
		breakup bk = new breakup(cp, k, n, content);// Least n happy couples broke up
		content = bk.break_print();
		for(i =0 ; i < n; i++)
		{
			for(j = 0;  j < b1; j++)
			{
				if(by[j].status == 0 && cp[i].girl.Status == 0 && by[j].budget >= cp[i].girl.maint_budg && cp[i].girl.Attractiveness >= by[j].att_req && !((by[j].name).equals(cp[i].boy.name))) {
						by[j].status = 1;
						cp[i].girl.Status = 1;
						String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
						content = content.concat("\n"+timeStamp+ " "+"New Commitment : "+cp[i].girl.name +"-"+by[j].name+" \n\n");//New commitments of broke up girls
						System.out.println("New Commitment after break up: "+cp[i].girl.name +"-"+by[j].name );
						cp[i].boy = by[j];
						break;
				}
			}
		}
		logger l1 = new logger();
		l1.log(content);
	}
}
