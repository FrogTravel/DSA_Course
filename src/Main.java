import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.go();

    }

    public void go(){
        NaiveSet naiveSet = new NaiveSet();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt")); //open read stream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] numbers = readIntegerArray(scanner); //read next line as number array
        if(numbers[0] != -1) // if line was empty, by condition it could be only >=0
        for (int value:numbers) {
            naiveSet.add(value);
        }

        System.out.println();

        numbers = readIntegerArray(scanner); //read next line as number array

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("output.txt", "UTF-8");//Write array stream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if(numbers[0] != -1)// if line was empty
        for (int value:numbers) {
            printWriter.print(naiveSet.isContain(value) + " ");
        }
        printWriter.close();
    }

    /**
     * Transform line in file to int array
     * Reads line then split it to string array or set -1 if line empty
     * Transform line to array
     * @return result array
     */
    private int[] readIntegerArray(Scanner scanner){
        String fullLine = scanner.nextLine();
        String[] temp;
        if(!fullLine.equals(""))
            temp = fullLine.split(" ");
        else {
            temp = new String[1];
            temp[0] = "-1";
        }
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }


}