/**
 * @author ekaterina
 * Contain 1 in right place of array, so we can check if that value was already
 * in set
 */
public class NaiveSet implements NaiveSetInterface {
    private long[] bits;

    public NaiveSet(){
        bits = new long[1563];//For magic numbers achievement 100000
            // which is maximum by condition of task
            // 100000/64(length of long) = 1562, so 1563 will be enough
    }

    /**
     * Shift 1 by value and "binary or" it with previous number,
     * so new value added to "set"
     * @param value that we want to add to set
     */
    @Override
    public void add(int value) {
        bits[value/64] = (1 << value) | bits[value/64];
    }

    /**
     * Shift 1 to left by value then binary NOT and AND with old number,
     * so new number has 0 on right place
     * @param value that we want to delete
     */
    @Override
    public void remove(int value) {
        bits[value/64] = (~(1 << value)) & bits[value/64];
    }

    /**
     * Gets right bit from right number in array
     * @param value that we want to check
     * @return if there is 1 on right place
     */
    @Override
    public boolean isContain(int value) {
        return (bits[value/64] & (1 << value)) == (1 << value);
    }
}
