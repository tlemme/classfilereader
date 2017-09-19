package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantString implements Constant {
    private final int stringIndex;


    ConstantString(int stringIndex) {
        this.stringIndex = stringIndex;
    }

    public static ConstantString read(DataInput input) throws IOException {
        int stringIndex = input.readUnsignedShort();
        return new ConstantString(stringIndex);
    }

    @Override
    public Type getType() {
        return Type.CONSTANT_STRING;
    }

    @Override
    public String toString() {
        return "[" + getType() + " stringIndex=" + stringIndex + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[" + getType() + " string=" + pool[stringIndex].toString(pool) + "]";
    }
}
