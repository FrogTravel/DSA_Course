/**
 * Created by ekaterina on 17.01.17.
 */
public class ControlSequence {
    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");

        String commands = reader.nextLine();
        int x = 0, y = 0;

        String[] str = commands.split("");

        for(int i = 0; i < commands.length(); i++){
            switch (str[i]){
                case "L":
                    x -= 1;
                    break;
                case "U":
                    y += 1;
                    break;
                case "R":
                    x += 1;
                    break;
                case "D":
                    y -= 1;
                    break;
            }
        }

        writer.write(String.valueOf(x) + " " + String.valueOf(y));
        writer.close();
    }


}
