package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class NameAndTypeConstant implements Constant {
    private final int nameIndex;
    private final int descriptorIndex;


    NameAndTypeConstant(int nameIndex, int descriptorIndex) {
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    public static NameAndTypeConstant read(DataInput input) throws IOException {
        int nameIndex = input.readUnsignedShort();
        int descriptorIndex = input.readUnsignedShort();
        return new NameAndTypeConstant(nameIndex, descriptorIndex);
    }

    @Override
    public String toString() {
        return "[MethodRefConstant nameIndex=" + nameIndex + ", descriptorIndex=\"" + descriptorIndex + "\"]";
    }
}
