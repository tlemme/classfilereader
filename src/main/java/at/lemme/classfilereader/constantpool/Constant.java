package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public interface Constant {

    enum Type {

        CONSTANT_CLASS(7),
        CONSTANT_FIELDREF(9),
        CONSTANT_METHODREF(10),
        CONSTANT_INTERFACE_METHODREF(11),
        CONSTANT_STRING(8),
        CONSTANT_INTEGER(3),
        CONSTANT_FLOAT(4),
        CONSTANT_LONG(5),
        CONSTANT_DOUBLE(6),
        CONSTANT_NAME_AND_TYPE(12),
        CONSTANT_UTF8(1),
        CONSTANT_METHOD_HANDLE(15),
        CONSTANT_METHOD_TYPE(16),
        CONSTANT_INVOKE_DYNAMIC(18);

        public final int value;

        Type(int value) {
            this.value = value;
        }

        public static Type of(int value) {
            for (Type c : values()) {
                if (c.value == value) {
                    return c;
                }
            }
            throw new IllegalArgumentException("No Constant Pool Type for value " + value);
        }

    }

    static Constant read(DataInput input) throws IOException {
        int tag = input.readUnsignedByte();
        Type type = Type.of(tag);
        switch (type) {
            case CONSTANT_UTF8:
                return ConstantUtf8.read(input);
            case CONSTANT_CLASS:
                return ConstantClass.read(input);
            case CONSTANT_FIELDREF:
                return ConstantFieldRef.read(input);
            case CONSTANT_METHODREF:
                return ConstantMethodRef.read(input);
            case CONSTANT_INTERFACE_METHODREF:
                return ConstantInterfaceMethodRef.read(input);
            case CONSTANT_STRING:
                return ConstantString.read(input);
            case CONSTANT_INTEGER:
                return ConstantInteger.read(input);
            case CONSTANT_FLOAT:
                return ConstantFloat.read(input);
            case CONSTANT_LONG:
                return ConstantLong.read(input);
            case CONSTANT_DOUBLE:
                return ConstantDouble.read(input);
            case CONSTANT_NAME_AND_TYPE:
                return ConstantNameAndType.read(input);
            case CONSTANT_METHOD_HANDLE:
                return ConstantMethodHandle.read(input);
            case CONSTANT_METHOD_TYPE:
                return ConstantMethodType.read(input);
            case CONSTANT_INVOKE_DYNAMIC:
                return ConstantInvokeDynamic.read(input);
        }

        throw new IllegalArgumentException("Unknown tag " + tag);
    }

    Type getType();
    String toString(Constant[] pool);
}
