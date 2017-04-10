/**
 * Function to assign key values
 * @author Raghav Tayal
 *
 */
public class LinkedHash {

    String key;

    int value;

    LinkedHash next;

    /**
     * Class constructor
     * @param key Key for hashing
     * @param value value for key
     */
    LinkedHash(String key, int value) {

        this.key = key;

        this.value = value;

        this.next = null;

    }
}
