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

    public void remove(int value);

    public boolean isContain(int value);
}
