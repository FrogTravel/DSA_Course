package ShuntingYard;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author ekaterina
 */
public class MainShunting {
    private LinkedQueue<String> linkedQueue = new LinkedQueue<>();
    private LinkedStack<String> linkedStack = new LinkedStack<>();
    private LinkedStack<Double> linkedStackRPN = new LinkedStack<>();

    public static void main(String[] args) {
        MainShunting mainShunting = new MainShunting();
        mainShunting.go();
    }

    /**
     * Split whole line to several tokens
     * Rewrite it to right order
     * Then count it
     * Write it to file
     */
    public void go() {
        StringTokenizer string = new StringTokenizer(readExpression(), " ()+-*/", true);

        shuntingYard(toArray(string));

        RPN();

        writeAnswer();
    }

    /**
     * Create writer
     * Write to file in right order
     * Close stream
     */
    private void writeAnswer() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        printWriter.write(String.format("%.2f", linkedStackRPN.pop()).replace(",", "."));
        printWriter.close();
    }

    /**
     * Simple converter from string tokenizer to array
     * @param string that we want to convert
     * @return result line
     */
    private String[] toArray(StringTokenizer string) {
        String[] result = new String[string.countTokens()];
        int counter = 0;
        while (string.hasMoreElements()) {
            result[counter] = string.nextToken();
            counter++;
        }
        return result;
    }

    /**
     * @return expression in human-readable form from input.txt file
     */
    private String readExpression() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return scanner.nextLine();
    }

    /**
     * Rewrite expression to right format using shuntingYard algorithm
     * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     * @param tokens from original expression
     */
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
                    if ((!linkedStack.isEmpty()) && ((linkedStack.top().equals("*")) || (linkedStack.top().equals("/")))) {
                        while (!linkedStack.isEmpty() && ((linkedStack.top().equals("*") || linkedStack.top().equals("/")))) {
                            linkedQueue.enqueue(linkedStack.pop());
                        }
                        linkedStack.push(token);
                    } else {
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

    /**
     * Count expression from queue
     */
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

    /**
     * @param str that we want to check
     * @return if str numeric type or not
     */
    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}
