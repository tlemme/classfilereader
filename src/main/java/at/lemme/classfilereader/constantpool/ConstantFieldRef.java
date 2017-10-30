package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_FIELDREF;

public final class ConstantFieldRef implements Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;


    ConstantFieldRef(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public static ConstantFieldRef read(DataInput input) throws IOException {
        int classIndex = input.readUnsignedShort();
        int nameAndTypeIndex = input.readUnsignedShort();
        return new ConstantFieldRef(classIndex, nameAndTypeIndex);
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_FIELDREF;
    }

    @Override
    public String toString() {
        return "[ConstantFieldRef classIndex=" + classIndex + ", nameAndTypeIndex=\"" + nameAndTypeIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantFieldRef class=" + pool[classIndex].toString(pool) + ", nameAndType=\"" + pool[nameAndTypeIndex].toString(pool) + "\"]";
    }
}
