import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.toHexString;

public class model {

    String input = new String();
    String key = "dong";
    String krypt = new String();




        private static String crypt_string(String input, String krypt, String key){
            for (int i = 0; i < input.length(); i++) {
                krypt += encrypt(input.charAt(i), key.charAt(i));
            }
            return krypt;
        }

        private static String extendKey(String key, String input) {
            if (key.length() < input.length()) {
                for (int i = 0; key.length() < input.length(); i++) {
                    key += key.charAt(i);
                }
            }
            return key;
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

    public static void main(String[] args) {
        String key = "dong";
        String input = "dingdingdi";
        System.out.println(extendKey(key, input));
    }
    }

