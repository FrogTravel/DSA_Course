/**
 * Created by ekaterina on 17.01.17.
 */
public class DobleMess {
    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");
        double input = Double.parseDouble(reader.nextLine());

        writer.write(String.valueOf(normalize(input)));
        writer.close();

    }

    public static double normalize(double numb){
        long longBits = Double.doubleToLongBits(numb);


        long sign = longBits << 63;
        long mantissa = (longBits >> 1) & 0x7FF;
        long exponent = (longBits >> 12) & 0xFFFFFFFFFFFFFL;


        double result = Double.longBitsToDouble(sign | exponent << 52 | mantissa);
        return result;
    }

}
