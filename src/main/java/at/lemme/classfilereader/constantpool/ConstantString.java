package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_STRING;

public final class ConstantString implements Constant {
    private final int stringIndex;

    ConstantString(int stringIndex) {
        this.stringIndex = stringIndex;
    }

    public static ConstantString read(DataInput input) throws IOException {
        int stringIndex = input.readUnsignedShort();
        return new ConstantString(stringIndex);
    }

    public int getStringIndex() {
        return stringIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_STRING;
    }

    @Override
    public String toString() {
        return "[ConstantString stringIndex=" + stringIndex + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantString string=" + pool[stringIndex].toString(pool) + "]";
    }
}
