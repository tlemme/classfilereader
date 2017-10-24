package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_METHODREF;

public final class ConstantMethodRef implements Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;


    ConstantMethodRef(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public static ConstantMethodRef read(DataInput input) throws IOException {
        int classIndex = input.readUnsignedShort();
        int nameAndTypeIndex = input.readUnsignedShort();
        return new ConstantMethodRef(classIndex, nameAndTypeIndex);
    }

    @Override
    public Type getType() {
        return CONSTANT_METHODREF;
    }

    @Override
    public String toString() {
        return "[ConstantMethodRef classIndex=" + classIndex + ", nameAndTypeIndex=\"" + nameAndTypeIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantMethodRef class=" + pool[classIndex].toString(pool) + ", nameAndType=\"" + pool[nameAndTypeIndex].toString(pool) + "\"]";
    }
}
