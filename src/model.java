import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class model {

    public static void main(String[] args) throws IOException {
        String input = new String();
        FileReader file = new FileReader("input.txt");


        BufferedReader bufferedreader = new BufferedReader(file);
        Scanner scanner = new Scanner(bufferedreader);

        while (scanner.hasNextLine()) {
            input = input + scanner.nextLine();
        }
        bufferedreader.close();
        System.out.println(input);
    }




    private static int encrypt(int input, int key) {
        return (input^key);
    }

    private static int decrypt(int input, int key) {
        return (input^key);
    }
}
