/**
 * Type of a boy 
 * @author Raghav Tayal
 *
 */
public class Miser extends Boy {
	/**
	 * Function to calculate happiness of miser boys
	 */
	double happyness(Girl gl, double sum, double hap_girl)
	{
		double hap;
		hap = this.budget - sum;
		return hap;
		/**
		 * @return happiness of miser
		 */
	}
}
