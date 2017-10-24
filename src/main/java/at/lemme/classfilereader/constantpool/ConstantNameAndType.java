package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_NAME_AND_TYPE;

public final class ConstantNameAndType implements Constant {
    private final int nameIndex;
    private final int descriptorIndex;


    ConstantNameAndType(int nameIndex, int descriptorIndex) {
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public static ConstantNameAndType read(DataInput input) throws IOException {
        int nameIndex = input.readUnsignedShort();
        int descriptorIndex = input.readUnsignedShort();
        return new ConstantNameAndType(nameIndex, descriptorIndex);
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_NAME_AND_TYPE;
    }

    @Override
    public String toString() {
        return "[ConstantNameAndType nameIndex=" + nameIndex + ", descriptorIndex=\"" + descriptorIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantNameAndType name=" + pool[nameIndex].toString(pool) + ", descriptor=\"" + pool[descriptorIndex].toString(pool) + "\"]";
    }
}
