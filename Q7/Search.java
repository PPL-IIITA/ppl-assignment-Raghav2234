import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 * This class is used to search elements using array or binary search
 * @author Raghav Tayal
 *
 */
public class Search {
	/**
	 * Function used to search gf in array
	 * @param couple couple array
	 * @param list list of boys 
	 * @param k no of couples formed
	 * @param content string content
	 * @return String for log file
	 */
	static String Arraylist(int couple[][], int list[], int k, String content)
	{
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		int i, j, flag ;
		for(i = 0; i < list.length; i++ )
		{
			flag = 0;
			for(j = 0; j < k; j++)
			{
				if(list[i] == couple[j][0]) {
					System.out.println(timeStamp+" Boy"+couple[j][0]+" is commited with Girl"+couple[j][1]);
					content = content.concat(timeStamp+" Boy"+couple[j][0]+" is commited with Girl"+couple[j][1]+"\n");
					flag = 0;
					break;
				}
				else {
					flag = 1;
					continue;
				}
			}
			if(flag == 1) {
				System.out.println(timeStamp +"  Boy"+list[i]+" is single.");
				content = content.concat(timeStamp +"  Boy"+list[i]+" is single.\n");
			}
		}
		return content;
	}
	/**
	 * Function used to search gf using binary search
	 * @param couple Couple details array
	 * @param l starting index
	 * @param r ending index
	 * @param x list value
	 * @param content string content
	 * @return String for log file
	 */
	static String BinarySearch(int couple[][], int l , int r, int x, String content)
	{
		int m; 
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		while (l <= r)
		  {
		    m = l + (r-l)/2;
		    if (couple[m][0] == x) { 
		    	System.out.println(timeStamp+"  "+"Boy"+couple[m][0]+" is committed to Girl"+couple[m][1]);
		    	content = content.concat(timeStamp+"  "+"Boy"+couple[m][0]+" is committed to Girl"+couple[m][1]+"\n");
		    	return content;
		    }
		    if (couple[m][0] < x) 
		        l = m + 1; 
		    else
		         r = m - 1; 
		  }
				System.out.println(timeStamp+"  "+"Boy"+x+" is single");
				content = content.concat(timeStamp+"  "+"Boy"+x+" is single\n");
				return content; 
	}
}
