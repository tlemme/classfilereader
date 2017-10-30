package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_METHOD_HANDLE;

public final class ConstantMethodHandle implements Constant {
    private final int referenceKind;
    private final int referenceIndex;


    ConstantMethodHandle(int referenceKind, int referenceIndex) {
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public static ConstantMethodHandle read(DataInput input) throws IOException {
        int referenceKind = input.readUnsignedByte();
        int referenceIndex = input.readUnsignedShort();
        return new ConstantMethodHandle(referenceKind, referenceIndex);
    }

    public int getReferenceKind() {
        return referenceKind;
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    @Override
    public Type getType() {
        return CONSTANT_METHOD_HANDLE;
    }

    @Override
    public String toString() {
        return "[ConstantMethodHandle referenceKind=" + referenceKind + ", referenceIndex=\"" + referenceIndex + "\"]";
    }

    @Override
    public String toString(Constant[] pool) {
        return "[ConstantMethodHandle class=" + pool[referenceKind].toString(pool) + ", nameAndType=\"" + pool[referenceIndex].toString(pool) + "\"]";
    }
}
