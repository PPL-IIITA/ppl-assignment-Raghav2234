/**
 * Type of a girl
 * @author Raghav Tayal
 *
 */
public class Normal extends Girl {

	@Override
	/**
	 * Function to calculate happiness of Normal girl
	 * @return happiness
	 */
	double happyness(Boy boy, Gift[] gt, int k) {
		double hap;
		int i = 0;
		int sum = 0, value = 0;
		while(i < k) {
			sum = sum + gt[i].price;
			value = value + gt[i].value;
			i++;
		}
		hap = sum + value - this.maint_budg;
		return hap;		
	}

}
