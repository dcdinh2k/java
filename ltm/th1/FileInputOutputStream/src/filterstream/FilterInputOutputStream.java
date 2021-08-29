package filterstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterInputOutputStream {
    public static void main(String[] args) throws IOException {
        Adler32 inChecker = new Adler32();
        Adler32 outChecker = new Adler32();
        CheckedInputStream in = null;
        CheckedOutputStream out = null;
        try {
            in = new CheckedInputStream(
                    new FileInputStream("src/txtfile/farrago.txt"),
                    inChecker);
            out = new CheckedOutputStream(
                    new FileOutputStream("src/txtfile/outagain.txt"),
                    outChecker);
        } catch (IOException e) {
            System.err.println("CheckedIOTest: " + e);
            System.exit(-1);
        }
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        System.out.println("Input stream check sum: " +
                inChecker.getValue());
        System.out.println("Output stream check sum: " +
                outChecker.getValue());
        in.close();
        out.close();
    }
}
