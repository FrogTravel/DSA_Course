/**
 * Created by ekaterina on 31.01.17.
 */
public interface NaiveSetInterface {
    /**
     * Shift 1 by value and "binary or" it with previous number,
     * so new value added to "set"
     * @param value that we want to add to set
     */
    public void add(int value);

    /**
     * Shift 1 to left by value then binary NOT and AND with old number,
     * so new number has 0 on right place
     * @param value that we want to delete
     */
    public void remove(int value);

    /**
     * Gets right bit from right number in array
     * @param value that we want to check
     * @return if there is 1 on right place
     */
    public boolean isContain(int value);
}
