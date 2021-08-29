package datastream;

import java.io.*;

public class DataInputOutputStream {
    public static void main(String[] args) {
        // write the data out
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new
                    FileOutputStream("src/txtfile/invoice.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
        int[] units = { 12, 8, 13, 29, 50 };
        String[] descs = { "Java T-shirt",
                "Java Mug",
                "Duke Juggling Dolls",
                "Java Pin",
                "Java Key Chain" };

        for (int i = 0; i < prices.length; i ++) {
            try {
                assert out != null;
                out.writeDouble(prices[i]);
                out.writeChar('\t');
                out.writeInt(units[i]);
                out.writeChar('\t');
                out.writeChars(descs[i]);
                out.writeChar('\n');
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        DataInputStream in = null;
        try {
            in = new DataInputStream(new
                    FileInputStream("src/txtfile/invoice.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double price;
        int unit;
        StringBuffer desc;
        double total = 0.0;

        String lineSepString = System.getProperty("line.separator");
        char lineSep = lineSepString.charAt(lineSepString.length()-1);

        try {
            while (true) {
                price = in.readDouble();
                in.readChar(); // throws out the tab
                unit = in.readInt();
                in.readChar(); // throws out the tab
                char chr;
                desc = new StringBuffer(20);
                while ((chr = in.readChar()) != lineSep)
                    desc.append(chr);
                System.out.println("You've ordered " +
                        unit + " units of " +
                        desc + " at $" + price);
                total = total + unit * price;
            }
        } catch (IOException e) {
        }
        System.out.println("For a TOTAL of: $" + total);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
