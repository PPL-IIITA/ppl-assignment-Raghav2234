	/**
	 * Characteristics of boys
	 * @author Raghav Tayal
	 *
	 */
public abstract class Boy {
		String name;
		int Intelligence;
		int Attractiveness;
		int budget;
		int att_req;
		int status;
		String type;
		/**
		 * Function that has to be overrided by child class 
		 * @param gl
		 * @param sum
		 * @param hap_gl
		 * @return happiness of boy
		 */
		abstract double happyness(Girl gl, double sum, double hap_gl);
}
