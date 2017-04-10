import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 * main class of the program
 * @author Raghav Tayal
 *
 */
public class main_7 {
	public static void main(String ar[]) {
		csv_create.log(); /**
		*generating csv file
		*/
		Scanner s = new Scanner(System.in);
		Gift gt[] = new Gift[100];
		Boy by[] = new Boy[100];
		Girl gl[] = new Girl[100];
		int[][] couple  = new int[20][2];
		csv_abst l = new csv_abst();/**
		*Abstracting data from log files and putting that into objects
		*/
		l.abstraction(gt, by, gl);
		int key;
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
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		Couple cp[] = new Couple[50];//Creating instances of couple class
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
						content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" \n\n");//New couple formed
						System.out.println(timeStamp+" "+by[j].name+" is committed to "+gl[i].name+"\n\n");
						cp[k] = new Couple(by[j], gl[i], gt, g1);
						couple[k][0] = j;
						couple[k][1] = i;
						k++;
				}
			}
		}
		char q1 = 's';
		int  temp1;
		int list[] = {2, 4, 8, 7, 18, 15, 13, 19};
		while(q1 != 'q') {
		System.out.println(timeStamp+"  Choose any of following options\n");
		System.out.println(timeStamp+"  1.Press 'a' for array search");
		System.out.println(timeStamp+"  2.Press 'b' for binary search");
		System.out.println(timeStamp+"  3.Press 'c' for Hash Table");
		System.out.println(timeStamp+"  4.Press 'd' for default selection");
		System.out.println(timeStamp+"  5.Press 'q' for quit");
		q1 = s.next().charAt(0);
		if(q1 == 'a') {
		content = Search.Arraylist(couple, list, k, content);
		content = content.concat("\n\n");
		}
		else if(q1 == 'b' || q1 == 'd') {
			for(i = 0 ; i < k; i++)
			{
				for(j = i+1; j < k; j++)
				{
					if(couple[i][0] > couple[j][0]) {
						temp1 = couple[i][0];
						couple[i][0] = couple[j][0];
						couple[j][0] = temp1;
						temp1 = couple[i][1];
						couple[i][1] = couple[j][1];
						couple[j][1] = temp1;
					}
				}
			}
			for(i = 0; i < list.length;i++)
			{
				content = Search.BinarySearch(couple, 0, k - 1, list[i], content);
			}
			content = content.concat("\n\n");
		}
		else if(q1 == 'c') {
			HashTable ht = new HashTable(10);

            for (i = 0; i < k; i++) {
                key = (couple[i][0]) % 10;
                ht.insert(Integer.toString(key), couple[i][0]);

            }

            for (i = 0; i < list.length; i++) {
                if (ht.get(Integer.toString(list[i] % 10)) == -1) {
                	content = content.concat(timeStamp +" "+"Boy" + list[i] + " is single\n");
                    System.out.println(timeStamp+" Boy" + list[i] + " is single");

                } else {
                    for (j = 0; j < k; j++) {
                        if (list[i] == couple[j][0]) {
                            System.out.println(timeStamp+" Boy" + list[i] + " is committed to Girl" + couple[j][1] + ".");
                            content = content.concat(timeStamp+" Boy" + list[i] + " is committed to Girl" + couple[j][1] + "\n");
                            break;
                        }
                    }
                }
            }
            content = content.concat("\n");
		}
	}
		logger l1 = new logger();
		l1.log(content);
	}
}
