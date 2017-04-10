import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class main_5 {
	public static void main(String args[]) {
		csv_create.log(); //generating csv file
		Gift gt[] = new Gift[100];
		Boy by[] = new Boy[100];
		Girl gl[] = new Girl[100];
		log_abst l = new log_abst();//Abstracting data from log files and putting that into objects
		l.abstraction(gt, by, gl);
		int g1 = l.m, b1 = l.n,gl1 = l.o;
		int i, j, k;
		Gift temp;	
		for(i = 0; i < g1; i++)//Sorting gifts according to price
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
		Boy boy;
		Girl girl;
		for(i = 0 ;i < b1; i++)
		{
			for(j = i+1; j < b1; j++)
			{
				if(by[i].Attractiveness > by[j].Attractiveness) {
					boy = by[i];
					by[i] = by[j];
					by[j] = boy;
				}
			}
		} 
		for(i = 0; i < gl1; i++)
		{
			for(j = i+1; j < gl1; j++)
			{
				if(gl[i].maint_budg > gl[j].maint_budg ) {
					girl = gl[i];
					gl[i] = gl[j];
					gl[j] = girl;
				}
			}
		}
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		int b = 0 , g = 0, c = 0, max = -1;
		String content ="";
		Couple cp[] = new Couple[50];//Creating instances of couple class
		//Making commitments
		for(i = 0 ; i < b1 + gl1  ; i++)
		{
			if(i % 2 ==0 &&  g < gl1) {
				for(j = 0 ; j < b1; j++)
				{
					if( gl[g].Status == 0 && by[j].status == 0 && by[j].budget >= gl[g].maint_budg  ) {
						gl[g].Status = 1;
						by[j].status = 1;
						cp[c] = new Couple(by[j], gl[g], gt, g1);
						c++;
						content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[g].name +"-"+by[j].name+" \n\n");//New couple formed after making commitments
						break;
					}
				}
				g++;		
			}
			else {
				k = -1;
				max = -1;
				for(j = 0; j < gl1; j++)
				{
					if(by[b].status == 0 && gl[j].Status == 0 && by[b].att_req <= gl[j].Attractiveness ){
						if( max < gl[j].Attractiveness) {
							max = gl[j].Attractiveness;
							k = j;
						}
					}
					
				}
				if(k != -1) {
					by[b].status = 1;
					gl[k].Status = 1;
					cp[c] = new Couple(by[b], gl[k], gt, g1);
					c++;
					content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[k].name +"-"+by[b].name+" \n\n");//New couple formed after making commitments
				}
				b++;
			}
		}
		Random rn = new Random();
		k = rn.nextInt(c);
		for(i = 0 ; i < c ; i++)//Calculating couple happiness
			cp[i].Happiness();
		Couple cl;
		for(i = 0; i < c  - 1 ;i++) 
		{
			for(j = i + 1; j < c; j++)
			{
				if(cp[i].hap < cp[j].hap) {
					cl = cp[i];
					cp[i] = cp[j];
					cp[j] = cl;
				}
			}
		}
		content = content.concat("\n"+timeStamp+ " "+k+" happiest couples "+" \n\n");
		for(i = 0; i < k; i++)
		{
			content = content.concat("\n"+timeStamp+ " "+"Commitment : "+cp[i].girl.name +"-"+cp[i].boy.name+" \n\n");
		}
		Logger lr = new Logger();
		lr.log(content);
		System.out.println(content);
	}
}