import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author ekaterina
 *
 * Read file with given name
 */
public class Reader {

    Scanner scanner;

    /**
     * Makes new object Scanner
     * @param fileName name that will be used for saving object
     */
    public Reader(String fileName){
        try {
            scanner = new Scanner(new File(fileName));
        }catch (FileNotFoundException e){

        }
    }

    /**
     * Read next line of scanner
     * @return null if no more lines
     * @return next line if has more
     */
    public String nextLine(){
        if(scanner.hasNextLine())
            return scanner.nextLine();
        else
            return null;
    }

    /**
     * Read int
     * @return 0 if no more numbers
     * @return next number
     */
    public int nextInt(){
        if(scanner.hasNextInt())
            return scanner.nextInt();
        else
            return 0;
    }



}
