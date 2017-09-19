package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public final class ConstantClass implements Constant {
    private final int nameIndex;


    ConstantClass(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public static ConstantClass read(DataInput input) throws IOException {
        int nameIndex = input.readUnsignedShort();
        return new ConstantClass(nameIndex);
    }

    @Override
    public Type getType() {
        return Type.CONSTANT_CLASS;
    }

    @Override
    public String toString() {
        return "[" + getType() + " nameIndex=" + nameIndex + "]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[" + getType() + " name=" + pool[nameIndex].toString(pool) + "]";
    }
}
