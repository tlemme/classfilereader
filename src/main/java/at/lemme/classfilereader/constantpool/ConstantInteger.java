package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_INTEGER;

public final class ConstantInteger implements Constant {
    private final int value;


    ConstantInteger(int value) {
        this.value = value;
    }

    public static ConstantInteger read(DataInput input) throws IOException {
        int value = input.readInt();
        return new ConstantInteger(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return CONSTANT_INTEGER;
    }

    @Override
    public String toString() {
        return "[ConstantInteger value=" + value + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
