package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_METHOD_TYPE;

public final class ConstantMethodType implements Constant {
    private final int descriptorIndex;

    ConstantMethodType(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public static ConstantMethodType read(DataInput input) throws IOException {
        int descriptorIndex = input.readUnsignedShort();
        return new ConstantMethodType(descriptorIndex);
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_METHOD_TYPE;
    }

    @Override
    public String toString() {
        return "[ConstantMethodType descriptorIndex=" + descriptorIndex + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantMethodType descriptorIndex=" + pool[descriptorIndex].toString(pool) + "]";
    }
}
