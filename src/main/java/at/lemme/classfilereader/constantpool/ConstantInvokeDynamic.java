package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantInvokeDynamic implements Constant {
    private final int bootstrapMethodAttrIndex;
    private final int nameAndTypeIndex;


    ConstantInvokeDynamic(int bootstrapMethodAttrIndex, int nameAndTypeIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public static ConstantInvokeDynamic read(DataInput input) throws IOException {
        int bootstrapMethodAttrIndex = input.readUnsignedShort();
        int nameAndTypeIndex = input.readUnsignedShort();
        return new ConstantInvokeDynamic(bootstrapMethodAttrIndex, nameAndTypeIndex);
    }

    @Override
    public String toString() {
        return "[ConstantInvokeDynamic bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex + ", nameAndTypeIndex=\"" + nameAndTypeIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantInvokeDynamic bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex + ", nameAndType=\"" + pool[nameAndTypeIndex].toString(pool) + "\"]";
    }
}
