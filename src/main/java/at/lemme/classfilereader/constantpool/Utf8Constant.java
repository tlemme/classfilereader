package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class Utf8Constant implements Constant {
    private final byte[] bytes;


    Utf8Constant(byte[] bytes) {
        this.bytes = bytes;
    }

    public static Utf8Constant read(DataInput input) throws IOException {
        int length = input.readUnsignedShort();
        byte[] bytes = new byte[length];
        input.readFully(bytes);
        return new Utf8Constant(bytes);
    }

    @Override
    public String toString() {
        return "[Utf8Constant length=" + bytes.length + ", content=\"" + new String(bytes) + "\"]";
    }
}
