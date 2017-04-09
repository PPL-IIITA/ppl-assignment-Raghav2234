import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Contain breakup details
 * @author Raghav Tayal
 * @version jdk 1.8.0
 */
public class breakup {
	Couple cp[];
	int k;
	int n;
	String s;/**
	*@constructor initialization 
	*@param cp
	*@param k
	*@param n
	*@param content
	*/
	breakup(Couple cp[],int k, int n, String content ){
		this.cp = cp;
		this.k = k;
		this.n = n;
		this.s = content;
	}/**
	*Print breakup details
	*@return string contain breakup details
	*/
	String break_print()
	{
		int i;
		for(i = 0 ; i < n; i++)
		{
			System.out.println(cp[i].boy.name+" brokeup with "+cp[i].girl.name);
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
			s = s.concat("\n"+timeStamp+" "+cp[i].boy.name+" brokeup with "+cp[i].girl.name+"\n\n");//Least n happy couples broke up
			cp[i].boy.status = 0;
			cp[i].girl.Status = 0;
		}
		return s;
	}
}
	

