package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_UTF8;

public final class ConstantUtf8 implements Constant {
    private final byte[] bytes;


    ConstantUtf8(byte[] bytes) {
        this.bytes = bytes;
    }

    public static ConstantUtf8 read(DataInput input) throws IOException {
        int length = input.readUnsignedShort();
        byte[] bytes = new byte[length];
        input.readFully(bytes);
        return new ConstantUtf8(bytes);
    }

    @Override
    public Type getType() {
        return CONSTANT_UTF8;
    }

    public String getString(){
        return new String(bytes);
    }

    @Override
    public String toString() {
        return String .format("[ConstantUtf8 length=%3d, content=\"%s\"]", bytes.length, new String(bytes));
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
