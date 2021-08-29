package datastream;

import java.io.*;
import java.util.zip.Adler32;

public class CustomDataInputOutput {
    public static void main(String[] args) throws IOException {
        Adler32 inChecker = new Adler32();
        Adler32 outChecker = new Adler32();
        CheckedDataInput in = null;
        CheckedDataOutput out = null;
        try {
            in = new CheckedDataInput(
                    new DataInputStream(
                            new FileInputStream("src/txtfile/farrago.txt")),
                    (Checksum) inChecker);
            out = new CheckedDataOutput(
                    new DataOutputStream(
                            new FileOutputStream("src/txtfile/outagain.txt")),
                    (Checksum) outChecker);
        } catch (FileNotFoundException e) {
            System.err.println("CheckedIOTest: " + e);
            System.exit(-1);
        }
        boolean EOF = false;
        while (!EOF) {
            try {
                int c = in.readByte();
                out.write(c);
            } catch (EOFException e) {
                EOF = true;
            }
        }
        System.out.println("Input stream check sum: " +
                in.getChecksum().getValue());
        System.out.println("Output stream check sum: " +
                out.getChecksum().getValue());
    }
}

