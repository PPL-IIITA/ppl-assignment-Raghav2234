import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Contain breakup details
 * @author Raghav Tayal
 *
 */
public class breakup {
	Couple cp[];
	int k;
	int n;
	String s;
	int l = 0;
	/**
	 * breakup constructor
	 * @param cp
	 * @param k
	 * @param n
	 * @param content
	 */
	breakup(Couple cp[],int k, int n, String content ){
		this.cp = cp;
		this.k = k;
		this.n = n;
		this.s = content;
	}
	/**
	 * used to print breakup details
	 * @return string 
	 */
	String break_print()
	{
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		System.out.println("\n"+timeStamp+" "+"Breakups after " + 30/n +" days");
		s = s.concat("\n"+timeStamp+" "+"Breakups after " + 30/n +" days");
		int i;
		for(i = 0 ; i < k; i++)
		{
			if(cp[i].girl.Status != 0 && cp[i].hap < n) {
				System.out.println(cp[i].boy.name+" brokeup with "+cp[i].girl.name);
				s = s.concat("\n"+timeStamp+" "+cp[i].boy.name+" brokeup with "+cp[i].girl.name+"\n\n");/**
				*Least happy couples broke up
				*/
				cp[i].boy.status = 0;
				cp[i].girl.Status = 0;
				l++;
			 }
		}
		if(l == 0) {
			System.out.println(timeStamp+ "  "+"No breakups\n");
		}
		return s;
	}
}
	

