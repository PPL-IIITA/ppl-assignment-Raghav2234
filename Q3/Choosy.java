/**
 * Type of a girl
 * @author Raghav Tayal
 *
 */
public class Choosy extends Girl {
	/**
	 * Function to calculate happiness of Choosy girl
	 *@return happyness
	 */
	double happyness(Boy boy, Gift gt[], int k)
	{
		double hap;
		int i = 0;
		int sum = 0, value = 0;
		while(i < k) {
			sum = sum + gt[i].price;
			if((gt[i].type).equals("Luxury")) {
				value = value + 2 * gt[i].value;
			}
			else {
				value = value + gt[i].value;
			}
			i++;
		}
		hap = Math.log(sum + value - this.maint_budg);
		return hap;		
		 
	}
}
