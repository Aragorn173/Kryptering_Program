import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.toHexString;

public class model {

    private String input;
    private String key;
    private String krypt;


        public void setInput(String message) {
            this.input = input;
        }
        public void setKey(String key) {
            this.key = key;
        }

        public String getCrypt() {
            return krypt;
        }


        public String crypt_string(){
            for (int i = 0; i < input.length(); i++) {
                krypt += encrypt(input.charAt(i), key.charAt(i));

            }
            return krypt;
        }

        public String extendKey() {
            if (key.length() < input.length()) {
                for (int i = 0; key.length() < input.length(); i++) {
                    key += key.charAt(i);
                }
            }
            return key;
        }


        private String fileread () throws IOException {
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


    public static void main(String[] args) {
        String k = "dong";
        String m = "dingdingdi";

        model cryptModel = new model();
        cryptModel.setInput(m);
        cryptModel.setKey(k);
        System.out.println(cryptModel.extendKey());
    }
}

