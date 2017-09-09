package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class MethodRefConstant implements Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;


    MethodRefConstant(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public static MethodRefConstant read(DataInput input) throws IOException {
        int classIndex = input.readUnsignedShort();
        int nameAndTypeIndex = input.readUnsignedShort();
        return new MethodRefConstant(classIndex, nameAndTypeIndex);
    }

    @Override
    public String toString() {
        return "[MethodRefConstant classIndex=" + classIndex + ", nameAndTypeIndex=\"" + nameAndTypeIndex + "\"]";
    }
}
