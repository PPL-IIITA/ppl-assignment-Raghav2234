/**
 * Creating couples
 * @author Raghav Tayal
 */
public class Couple {
	Boy boy;
	Girl girl;
	Gift gt[];
	double hap;
	int n;
	/**
	 * Couple class constructor
	 * @param boy
	 * @param girl
	 * @param gift
	 * @param no
	 */
	Couple(Boy boy, Girl girl, Gift gift[], int no){
		this.boy = boy;
		this.girl = girl;
		this.gt = gift;
		this.hap = 0;
		this.n = no;
	}/**
	*Calculate happiness of couple
	*By calculating happiness of boy and girl 
	*/
	 void Happiness()
	{
		 int i = 0, j = n-1, k = 0;
		 int sum = 0, value = 0, val_ch = 0;
		if((boy.type).equals("Miser")) {
			while(sum + gt[0].price <= girl.maint_budg) {
				sum = sum + gt[i].price;
				value = value + gt[i].value;
				if((gt[i].type).equals("Luxury")) {
					val_ch = val_ch + gt[i].value;
				}
				i++;
			}
			if( i == 0 ) {
				sum = sum + gt[i].price;
				value = value + gt[i].value;
				if((gt[i].type).equals("Luxury")) {
					val_ch = val_ch + gt[i].value;
				}
			}
			if(sum > boy.budget) {
				boy.budget = sum;
			}
			hap = hap + (boy.budget - sum); 
		}
		if((boy.type).equals("Generous")) {
			while(sum + gt[0].price<= boy.budget) {
				sum = sum + gt[j].price;
				value = value + gt[j].value;
				if((gt[j].type).equals("Luxury")) {
					val_ch = val_ch + gt[j].value;
				}
				j--;
				k++;
			}
			if (k == 0 ) {
				sum = sum + gt[n].price;
				value = value + gt[n - 1].price;
				if((gt[n - 1].type).equals("Luxury")) {
					val_ch = val_ch + gt[n - 1].value;
				}
			}
			if(sum > boy.budget) {
				boy.budget = sum;
			}
		}
		if((boy.type).equals("Geek")) {
			while(sum + gt[0].price<= girl.maint_budg) {
				sum = sum + gt[i].price;
				value = value + gt[i].value;
				if((gt[i].type).equals("Luxury")) {
					val_ch = val_ch + gt[i].value;
				}
				i++;
			}
			if( i == 0 ) {
				sum = sum + gt[i].price;
				value = value + gt[i].value;
				if((gt[i].type).equals("Luxury")) {
					val_ch = val_ch + gt[i].value;
				}
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
				value = value + gt[k].value;
				if((gt[k].type).equals("Luxury")) {
					val_ch = val_ch + gt[k].value;
				}
			}
			hap = hap + girl.Intelligence;
		}
			switch(girl.type) {
			case "Choosy":
				hap = hap + Math.log(sum +value+val_ch - girl.maint_budg);
				if(hap < 0 ) {
					hap = 0;
				}
				break;
			case "Normal":
				hap = hap +sum + value - girl.maint_budg;
				break;
			case "Desperate":
				hap = hap + Math.exp((sum - girl.maint_budg)*0.1);
				break;
			}
			if((boy.type).equals("Generous")) {
				hap = hap * 2;
			}
		}
	}

