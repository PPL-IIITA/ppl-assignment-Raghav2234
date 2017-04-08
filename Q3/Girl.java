/**
 * Characteristics of girl
 * @author Raghav Tayal
 *
 */
public abstract class Girl {
	String name;
	int Intelligence;
	int Attractiveness;
	int maint_budg;
	String type;
	int Status;
	/**
	 * Abstract function that has to be overrided by child class
	 * @param boy
	 * @param gt
	 * @param k
	 * @return happiness
	 */
	abstract double happyness(Boy boy, Gift gt[], int k);
}

