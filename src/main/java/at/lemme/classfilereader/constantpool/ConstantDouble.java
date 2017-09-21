package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantDouble implements Constant {
    private final double value;

    ConstantDouble(double value) {
        this.value = value;
    }

    public static ConstantDouble read(DataInput input) throws IOException {
        double value = input.readDouble();
        return new ConstantDouble(value);
    }

    @Override
    public String toString() {
        return "[ConstantDouble value=" + value + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
