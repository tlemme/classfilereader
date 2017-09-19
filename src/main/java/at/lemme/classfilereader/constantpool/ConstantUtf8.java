package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantUtf8 implements Constant {
    private final byte[] bytes;


    ConstantUtf8(byte[] bytes) {
        this.bytes = bytes;
    }

    public static ConstantUtf8 read(DataInput input) throws IOException {

        int u1 = input.readUnsignedByte();
        int u2 = input.readUnsignedShort();
        int u4 = input.readInt();


        int length = input.readUnsignedShort();
        byte[] bytes = new byte[length];
        input.readFully(bytes);
        return new ConstantUtf8(bytes);
    }

    @Override
    public Type getType() {
        return Type.CONSTANT_UTF8;
    }

    public String getString(){
        return new String(bytes);
    }

    @Override
    public String toString() {
        return String .format("[%s length=%3d, content=\"%s\"]", getType(), bytes.length, new String(bytes));
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
