package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ClassConstant implements Constant {
    private final int nameIndex;


    ClassConstant(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public static ClassConstant read(DataInput input) throws IOException {
        int nameIndex = input.readUnsignedShort();
        return new ClassConstant(nameIndex);
    }

    @Override
    public String toString() {
        return "[ClassConstant nameIndex=" + nameIndex + "]";
    }
}
