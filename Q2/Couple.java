import java.sql.Timestamp;
import java.text.SimpleDateFormat;
//Identifies details about couples
public class Couple {
	int i,j, l;
	void create(Gift gt[], int g1, Boy_2 by[], int b1, Girl_2 gl[], int g ){
		i = 0;
		j = 0;
		int n = -1;
		int k, sum, t, sum1;
		Boy_2 bal[] = new Boy_2[100];
		Girl_2 gal[] = new Girl_2[100];
		String content = "";
		int commit[] = new int[50];
		double hap[] = new double[50];
		for(i = 0; i < g; i++) {
			for( j = 0; j < b1; j++ )
			{
				if(by[j].budget >= gl[i].maint_budg &&  gl[i].Attractiveness >= by[j].attr_req && by[j].status == 0) {   //Commitment between boy and girl
					String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
					content = content.concat("\n"+timeStamp+ " "+"Commitment : "+gl[i].name +"-"+by[j].name+" \n\n");//Stores commitment status
					by[j].status = 1;
					n++;
					if((by[j].type).equals("Miser" )) {	
						k = 0;
						sum = 0;
						t = 0;
						sum1 = 0;
						bal[n] = new Boy_2();
						gal[n] = new Girl_2();
						bal[n] = by[j];
						gal[n] = gl[i];
						while(sum <= gal[n].maint_budg) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t + gt[k].price+ 2 * gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
							k++;
						}
						if(k == 0) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum  = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t +  gt[k].price+2* gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
						}
						if(sum > bal[n].budget) {
							bal[n].budget = sum;
						}
						commit[n] = bal[n].budget - gal[n].maint_budg + Math.abs(by[j].Attractiveness - gl[i].Attractiveness)+Math.abs(by[j].Attractiveness - gl[i].Attractiveness);
						//Calculating happiness between couples
						switch(gal[n].type){
							case "Choosy":
								hap[n] = Math.log(t-gal[n].maint_budg);
								if(hap[n] < 0) {
									hap[n] = 0;
								}
								break;
							case "Normal":
								hap[n] = sum+sum1 - gal[n].maint_budg;
								break;
							case "Desperate":
								hap[n] = Math.exp(((double)sum - gal[n].maint_budg)/100);
								break;
						}
						hap[n] = hap[n] + (bal[n].budget - sum);
					}
					if((by[j].type).equals("Generous")  ) {
						k = 0;
						sum = 0;
						t = 0;
						sum1 = 0;
						bal[n] = by[j];
						gal[n] = gl[i];
						while(sum <= by[j].budget) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t + gt[k].price + 2* gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
							k++;
						}
						if(k == 0) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum  = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t + gt[k].price+2*gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
						}
						if(sum > bal[n].budget) {
							bal[n].budget = sum;
						}
						commit[n] = bal[n].budget - gal[n].maint_budg + Math.abs(by[j].Attractiveness - gl[i].Attractiveness)+Math.abs(by[j].Attractiveness - gl[i].Attractiveness);
						switch(gal[n].type){
							case "Choosy":
								hap[n] = Math.log(t - (double)gal[n].maint_budg);
								if(hap[n] < 0) {
									hap[n] = 0;
								}
								break;
							case "Normal":
								hap[n] = sum+sum1 - gal[n].maint_budg;
								break;
							case "Desperate":
								hap[n] = Math.exp(((double)sum - gal[n].maint_budg)/100);
								break;
						}
						hap[n] = 2*hap[n];
					}
					if((by[j].type).equals("Geek")  ) {
						k = 0;
						sum = 0;
						t = 0;
						sum1 = 0;
						bal[n] = by[j];
						gal[n] = gl[i];

						while(sum <= gal[n].maint_budg) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t +  gt[k].price+2 * gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
							k++;
						}
						if(k == 0) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[k].name+" to "+gl[i].name+"\n");
							sum = sum + gt[k].price;
							sum1 = sum1 + gt[k].value;
							if((gt[k].type).equals("Luxury")) {
								t = t + gt[k].price + 2 * gt[k].value;
							}
							else {
								t = t + gt[k].price + gt[k].value;
							}
						}
						if(sum > bal[n].budget) {
							bal[n].budget = sum;
						}
						for(l = 0; l < g1; l++)
						{
							if((gt[l].type).equals("Luxury")) {
								break;
							}
						}
						if((bal[n].budget - sum) >= gt[l].price) {
							content = content.concat(timeStamp+" "+by[j].name+" gifts "+gt[l].name+" to "+gl[i].name+"\n");
							sum  = sum + gt[l].price;
							sum1 = sum1 + gt[l].value;
							if((gt[l].type).equals("Luxury")) {
								t = t + gt[l].price + 2 * gt[l].value;
							}
							else {
								t = t + gt[l].price + gt[l].value;
							}
						}
						//Calculating compatibility between couples
						commit[n] = bal[n].budget - gal[n].maint_budg + Math.abs(by[j].Attractiveness - gl[i].Attractiveness)+Math.abs(by[j].Attractiveness - gl[i].Attractiveness);
						switch(gal[n].type){
							case "Choosy":
								hap[n] = Math.log(t- (double)gal[n].maint_budg);
								if(hap[n] < 0) {
									hap[n] = 0;
								}
								break;
							case "Normal":
								hap[n] = sum+sum1 - gal[n].maint_budg;
								break;
							case "Desperate":
								hap[n] = Math.exp(((double)sum - gal[n].maint_budg)/100);
								break;
						}
						hap[n] = hap[n] + gal[n].Intelligence;
					}
					break;
				}
			}
		}
		out_res o = new out_res();
		//Function to print results
		o.crea_data(bal,gal, n, hap, commit, content);
	}
}
