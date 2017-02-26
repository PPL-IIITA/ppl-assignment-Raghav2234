import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;
public class out_res {
	int i, j, k, l,m;
	Boy_2 boy[];
	Girl_2 girl[];
	String s;
	Random rn = new Random();
	void crea_data(Boy_2 bal[], Girl_2 gal[], int n, double hap[], int commit[], String ab){//Print data and send to log file
		s = ab;
		double d;
		int a[] = new int[100];
		int b[] = new int[100];
		for(i = 0 ; i <= n; i++)
		{
			a[i] = i;
			b[i] = i;
		}
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		s = s.concat("\n"+timeStamp+"  "+"Printing couples in decreasing order of happiness\n");
		//Sorting happiness		
		for(i = 0 ; i <= n; i++)
		{
			for(j = i+1 ; j <= n ; j++)
			{
				if(hap[i] < hap[j]) {
					d = hap[i];
					hap[i] = hap[j];
					hap[j] = d;
					k = a[i];
					a[i] = a[j];
					a[j] = k;
				}
			}
		}
		//Sorting compatibility
		for(i = 0; i <= n ;i++)
		{
			for(j = i + 1; j <= n ;j++) {
				if(commit[i]<commit[j]) {
					l = commit[i];
					commit[i] = commit[j];
					commit[j] = l;
					m = b[i];
					b[i] = b[j];
					b[j] = m;
				}
			}
		}
		k = rn.nextInt(n);
		for(i = 0; i <= k ;i++)
		{
			s = s.concat(timeStamp+ "  "+i+"."+bal[a[i]].name +"-"+gal[a[i]].name+"\n"); 
		}
		s = s.concat("\n"+timeStamp +"  "+"Printing couples in decreasing order of compatibility\n");
		for(i = 0; i <= k ;i++)
		{
			s = s.concat(timeStamp+ "  "+i+"."+bal[b[i]].name +"-"+gal[b[i]].name+"\n"); 
		}
		//Creating output log file
		logger l = new logger();
		l.log(s);
		System.out.println(s);
	}
}
