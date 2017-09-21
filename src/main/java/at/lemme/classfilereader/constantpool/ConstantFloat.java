package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantFloat implements Constant {
    private final float value;


    ConstantFloat(float value) {
        this.value = value;
    }

    public static ConstantFloat read(DataInput input) throws IOException {
        float value = input.readFloat();
        return new ConstantFloat(value);
    }

    @Override
    public String toString() {
        return "[ConstantFloat value=" + value + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return toString();
    }
}
