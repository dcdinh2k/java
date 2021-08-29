package fileinputouput;

import java.io.*;
import java.sql.SQLOutput;

public class FileInputOutputStream {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("src/txtfile/farrago.txt");
        File outputFile = new File("src/txtfile/outagain.txt");

        try {
            FileInputStream in = new FileInputStream(inputFile);
            FileOutputStream out = new FileOutputStream(outputFile);
            int c;
            while((c = in.read())!= -1){
                System.out.println(c);
                out.write(c);
            }

            System.out.println("FileInputStream is used to read a file and FileOutPutStream is used for writing.");

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
