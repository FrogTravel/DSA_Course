/**
 * Created by ekaterina on 17.01.17.
 */
public class ToUpperCase {
    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");

        String string = reader.nextLine();

        writer.write(string.toUpperCase());
        writer.close();
    }
}
