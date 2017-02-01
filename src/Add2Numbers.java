/**
 * Created by ekaterina on 17.01.17.
 */
public class Add2Numbers {
    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");

        int a = 0, b = 0;

        a = reader.nextInt();
        b = reader.nextInt();


        writer.write(String.valueOf(add(a,b)));
        writer.close();
    }

    /**
     * @param a first number
     * @param b second number
     * @return sum of them (a+b)
     */
    private static int add(int a, int b) {
        return a+b;
    }

}
