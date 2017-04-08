/**
 * Type of a girl
 * @author Raghav Tayal
 *
 */
public class Desperate extends Girl {

	@Override
	/**
	 * Function to calculate happiness of desperate girl
	 *@return happyness
	 */
	double happyness(Boy boy, Gift[] gt, int k) {
		double hap;
		int i = 0;
		int sum = 0;
		while(i < k) {
			sum = sum + gt[i].price;
			i++;
		}
		hap = Math.exp(sum- this.maint_budg);
		return hap;		
	}

}
