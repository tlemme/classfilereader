package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantLong implements Constant {
    private final long value;

    ConstantLong(long value) {
        this.value = value;
    }

    public static ConstantLong read(DataInput input) throws IOException {
        long value = input.readLong();
        return new ConstantLong(value);
    }

    public long getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return Type.CONSTANT_LONG;
    }

    @Override
    public String toString() {
        return "[ConstantLong value=" + value + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
