import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Main class of the program
 * @author Raghav Tayal
 * @version jdk 1.8.0
 */
public class main_6 {
	public static void main(String args[])
	{
		csv_create.log(); /**
		*Generating csv file
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
		int t;
		Random rn = new Random();
		t = rn.nextInt(30) + 1;
		String content ="";
		Couple cp[] = new Couple[50];/**
		*Creating instances of couple class
		*Making commitments
		*/
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		System.out.println(timeStamp+" "+"Initial commitments:"+"\n\n");
		content = content.concat(timeStamp+" "+"Initial commitments:"+"\n\n");
		for(i = 0; i < gl1 ; i++)
		{
			for(j = 0 ; j < b1; j++)
			{
				if(by[j].status == 0 && gl[i].Status == 0 && by[j].budget >= gl[i].maint_budg && gl[i].Attractiveness >= by[j].att_req) {
						
						by[j].status = 1;
						gl[i].Status = 1;
						content = content.concat(timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" \n\n");
						/**
						*New couple formed
						*/
						System.out.println("\n"+timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" ");
						cp[k] = new Couple(by[j], gl[i], gt, g1);
						k++;
				}
			}
		}
		int n, m = 0;
		while(m < t) {
			breakup bk = new breakup(cp,k,t,content);
			content = bk.break_print();
			System.out.println("\n"+timeStamp+" "+"Commitment after next "+30/t+" days");
			content = content.concat("\n"+timeStamp+" "+"Commitment after next "+30/t+" days");
			n = bk.l;
			if(n == 0 ) {
				System.out.println(timeStamp + "  "+"No new commitments");
				content = content.concat(timeStamp +"  "+"No new commitments"+"\n\n");
				break;
			}
			k = 0;
			for(i =0 ; i < n; i++)
			{
				for(j = 0;  j < b1; j++)
				{
					if(by[j].status == 0 && cp[i].girl.Status == 0 && by[j].budget >= cp[i].girl.maint_budg && cp[i].girl.Attractiveness >= by[j].att_req && !((by[j].name).equals(cp[i].boy.name))) {
							by[j].status = 1;
							cp[i].girl.Status = 1;
							content = content.concat("\n"+timeStamp+ " "+"New Commitment : "+cp[i].girl.name +"-"+by[j].name+" \n\n");//New commitments of broke up girls
							System.out.println("New Commitment after break up: "+cp[i].girl.name +"-"+by[j].name );
							cp[i].boy = by[j];
							cp[i].Happiness();
							k++;
							break;
					}
				}
			}
			m++;
		}
	}
}
