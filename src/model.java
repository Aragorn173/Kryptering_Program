import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.toHexString;

public class model {

    public static void main(String[] args) throws IOException {
        String input = new String();
        int m;
        int key = '(';
        String krypt = new String();

        fileread(input);
        toHex(input);
        System.out.println(krypt);

        System.out.println(fileread(input));

        System.out.println(krypt);
    }




        private static String toHex (String input, String krypt, int key){
            int m;
            for (int i = 0; i < input.length(); i++) {
                m = input.charAt(i);
                String hex = toHexString(encrypt(key,m));
                krypt += hex;
            }
            return krypt;
        }



        private static String fileread (String input) throws IOException {
            FileReader file = new FileReader("input.txt");


            BufferedReader bufferedreader = new BufferedReader(file);
            Scanner scanner = new Scanner(bufferedreader);

            while (scanner.hasNextLine()) {
                input = input + scanner.nextLine();
            }
            bufferedreader.close();
            return input;
        }


        private static int encrypt ( int m, int key){
            return (m ^ key);
        }

        private static int decrypt ( int m, int key){
            return (m ^ key);
        }
    }

