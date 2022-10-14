import java.io.*;
import java.util.Scanner;

public class model {

    private String input = "";
    private String key;
    private String krypt = "";


        public void setInput(String input) {
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
                krypt += (char) encrypt(input.charAt(i), key.charAt(i));

            }
            return krypt;
        }

        public String extendKey() {
            if (input.length() > key.length()) {
                for (int i = 0; key.length() < input.length(); i++) {
                    key += key.charAt(i);
                }
            }
            return key;
        }


        public String fileread () {
            FileReader file = null;
            try {
                file = new FileReader("input.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            BufferedReader bufferedreader = new BufferedReader(file);
            Scanner scanner = new Scanner(bufferedreader);

            while (scanner.hasNextLine()) {
                input = input + scanner.nextLine();
            }
            try {
                bufferedreader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return input;
        }


        public void filewrite() {
        String str = krypt;
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("output.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        private int encrypt ( int m, int key){
            return (m ^ key);
        }


    public static void main(String[] args) {
        String k = "¤%";
        String input = "";

        model cryptModel = new model();
        input = cryptModel.fileread();
        cryptModel.setInput(input);
        cryptModel.setKey(k);
        System.out.println(cryptModel.extendKey());
        System.out.println(cryptModel.crypt_string());
        cryptModel.filewrite();
    }
}