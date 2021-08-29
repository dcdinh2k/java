package datastream;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import datastream.Adler32;
public class CheckedDataInput {
    private Checksum cksum;
    private DataInput in;
    public CheckedDataInput(DataInput in, Checksum cksum) {
        this.cksum = cksum;
        this.in = in;
    }

    public CheckedDataInput(DataInputStream in, Checksum inChecker) {
    }

    public byte readByte() throws IOException {
        byte b = in.readByte();
        cksum.update(b);
        return b;
    }
    public void readFully(byte[] b) throws IOException {
        in.readFully(b, 0, b.length);
        cksum.update(b, 0, b.length);
    }
    public void readFully(byte[] b, int off, int len) throws IOException {
        in.readFully(b, off, len);
        cksum.update(b, off, len);
    }
    public Checksum getChecksum() {
        return cksum;
    }
}
