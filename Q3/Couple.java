/**
 * Creating couples
 * @author Raghav Tayal
 *
 */
public class Couple {
	Boy boy;
	Girl girl;
	Gift gt[];
	double hap;
	int n;
	/**
	*Couple class constructor
	*/
	Couple(Boy boy, Girl girl, Gift gift[], int no){
		this.boy = boy;
		this.girl = girl;
		this.gt = gift;
		this.hap = 0;
		this.n = no;
	}
	/**
	 * Calculate happiness of couples
	 * @return happiness of couple
	 */
	double Happiness()
	{
		Gift g[] = new Gift[50];
		int i = 0, j = n-1, k = 0;
		int sum  = 0;
		double happy = 0;
		if((boy.type).equals("Miser")) {
			while(sum + gt[0].price <= girl.maint_budg) {
				sum = sum + gt[i].price;
				g[i] = gt[i];
				i++;
			}
			if( i == 0 ) {
				sum = sum + gt[i].price;
				g[i] = gt[i];
				i++;
			}
			if(sum > boy.budget) {
				boy.budget = sum;
			}
			happy = girl.happyness(boy, g, i );/**
			*Happiness of girl
			*/
			happy = happy + boy.happyness(girl, sum, happy);/**
			*Happiness of couple
			*/
		}
		if((boy.type).equals("Generous")) {
			while(sum + gt[0].price <= boy.budget) {
				sum = sum + gt[j].price;
				g[k] = gt[j];
				j--;
				k++;
			}
			if (k == 0 ) {
				sum = sum+ gt[n].price;
				g[k] = gt[n];
				k++;
			}
			if(sum > boy.budget) {
				boy.budget = sum;
			}
			happy = girl.happyness(boy, g, k);/**
			*Happiness of girl
			*/
			happy = happy + boy.happyness(girl, sum, happy);/**
			*Happiness of couple
		*/
		}
		if((boy.type).equals("Geek")) {
			while(sum + gt[0].price<= girl.maint_budg) {
				sum = sum + gt[i].price;
				g[i] = gt[i];
				i++;
			}
			if( i == 0 ) {
				sum = sum + gt[i].price;
				g[i] = gt[i];
				i++;
			}
			if(sum > boy.budget) {
				boy.budget = sum;
			}
			for(k = 0; k < n; k++)
			{
				if((gt[k].type).equals("Luxury")) {
					break;
				}
			}
			if((boy.budget - sum ) >= gt[k].price) {
				sum = sum + gt[k].price;
				g[i] = gt[k];
				i++;
			}
			happy = girl.happyness(boy, g, i);/**
			*Happiness of girl
			*/
			happy = happy + boy.happyness(girl, sum, happy);/**
			*Happiness of couple
			*/
		}
		return happy;
}
	int compatibility()
	{
		int x;
		x = boy.budget - girl.maint_budg +Math.abs(boy.Attractiveness - girl.Attractiveness)+Math.abs(boy.Intelligence - girl.Intelligence);
		return x;
	}
}

