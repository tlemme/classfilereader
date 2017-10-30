package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_FLOAT;

public final class ConstantFloat implements Constant {
    private final float value;


    ConstantFloat(float value) {
        this.value = value;
    }

    public static ConstantFloat read(DataInput input) throws IOException {
        float value = input.readFloat();
        return new ConstantFloat(value);
    }

    public float getValue() {
        return value;
    }

    @Override
    public Type getType() {
        return CONSTANT_FLOAT;
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
