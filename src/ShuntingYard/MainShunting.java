package ShuntingYard;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by ekaterina on 05.02.17.
 */
public class MainShunting {
    LinkedQueue<String> linkedQueue = new LinkedQueue<>();
    LinkedStack<String> linkedStack = new LinkedStack<>();
    LinkedStack<Double> linkedStackRPN = new LinkedStack<>();

    public static void main(String[] args) {
        MainShunting mainShunting = new MainShunting();
        mainShunting.go();
    }

    public void go() {
        StringTokenizer string = new StringTokenizer(readExpression(), " ()+-*/", true);

        shuntingYard(toArray(string));

        RPN();

        writeAnswer();
    }

    private void writeAnswer() {
        PrintWriter printWriter = null;
        try{
            printWriter = new PrintWriter(new File("output.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        printWriter.write(String.valueOf(linkedStackRPN.pop()));
        printWriter.close();
    }

    private String[] toArray(StringTokenizer string) {
        String[] result = new String[string.countTokens()];
        int counter = 0;
        while (string.hasMoreElements()) {
            result[counter] = string.nextToken();
            counter++;
        }
        return result;
    }

    private String readExpression() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scanner.nextLine();
    }

    private void shuntingYard(String[] tokens) {
        for (String token : tokens) {

            switch (token) {
                case "/":
                case "*":
                    if ((linkedStack.isEmpty()) || (linkedStack.top().equals("/")) || (linkedStack.top().equals("*")) || (linkedStack.top().equals("("))) {
                        linkedStack.push(token);
                    } else {
                        linkedQueue.enqueue(token);
                    }
                    break;
                case "+":
                case "-":

                    if((!linkedStack.isEmpty()) && ((linkedStack.top().equals("*"))||(linkedStack.top().equals("/")))){
                        while(!linkedStack.isEmpty() && ((linkedStack.top().equals("*") || linkedStack.top().equals("/")))) {
                            linkedQueue.enqueue(linkedStack.pop());
                        }
                        linkedStack.push(token);
                    }else{
                        linkedStack.push(token);
                    }
                    break;

                case "(":
                    linkedStack.push(token);
                    break;

                case ")":
                    while (!linkedStack.top().equals("(")) {
                        linkedQueue.enqueue(linkedStack.pop());
                    }
                    linkedStack.pop();
                    break;
                default:
                    if (isNumeric(token)) {
                        linkedQueue.enqueue(token);
                    }
            }
        }
        while (!linkedStack.isEmpty()) {

            linkedQueue.enqueue(linkedStack.pop());
        }
    }

    private void showStack() {
        LinkedStack<String> temp = new LinkedStack<>();
        temp = linkedStack;
        while (!temp.isEmpty()){
            System.out.print(temp.pop() + " ");
        }
    }

    private void showQueue(){
        LinkedQueue<String> queue = linkedQueue;
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
    }

    public void RPN() {
        String token;
        double a, b;
        while (!linkedQueue.isEmpty()) {
            switch (token = linkedQueue.dequeue()) {
                case "/":
                    a = linkedStackRPN.pop();
                    b = linkedStackRPN.pop();
                    linkedStackRPN.push((float) b / a);
                    break;
                case "*":
                    a = linkedStackRPN.pop();
                    b = linkedStackRPN.pop();
                    linkedStackRPN.push((float) a * b);
                    break;
                case "+":
                    a = linkedStackRPN.pop();
                    b = linkedStackRPN.pop();
                    linkedStackRPN.push((float) a + b);
                    break;
                case "-":
                    a = linkedStackRPN.pop();
                    b = linkedStackRPN.pop();
                    linkedStackRPN.push((float) b - a);
                    break;

                default:

                    if (isNumeric(token)) {
                        linkedStackRPN.push(Double.parseDouble(token));
                    }
            }
        }
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
