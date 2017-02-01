import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author ekaterina
 */
public class Writer {
    PrintWriter printWriter;


    /**
     * Constructor that makes new PrintWriter object using given name
     * @param filename
     */
    public Writer(String filename){
        try {
            printWriter = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    /**
     * Writes file
     * @param s
     */
    public void write(String s){
        printWriter.print(s);
    }

    public void write(HashSet<String> set){
        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            printWriter.print(iterator.next() + "\n");
        }
    }

    public void write(String[] s){
        for(String word : s){
            printWriter.print(word);
        }
    }
    /**
     * Close write "thread"
     */
    public void close(){
        printWriter.close();
    }

}