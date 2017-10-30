package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_INTERFACE_METHODREF;

public final class ConstantInterfaceMethodRef implements Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;


    ConstantInterfaceMethodRef(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public static ConstantInterfaceMethodRef read(DataInput input) throws IOException {
        int classIndex = input.readUnsignedShort();
        int nameAndTypeIndex = input.readUnsignedShort();
        return new ConstantInterfaceMethodRef(classIndex, nameAndTypeIndex);
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_INTERFACE_METHODREF;
    }

    @Override
    public String toString() {
        return "[ConstantInterfaceMethodRef classIndex=" + classIndex + ", nameAndTypeIndex=\"" + nameAndTypeIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantInterfaceMethodRef class=" + pool[classIndex].toString(pool) + ", nameAndType=\"" + pool[nameAndTypeIndex].toString(pool) + "\"]";
    }
}
