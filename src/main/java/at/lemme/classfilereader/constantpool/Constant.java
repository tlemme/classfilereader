package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public interface Constant {

    static final int CONSTANT_CLASS = 7;
    static final int CONSTANT_FIELDREF = 9;
    static final int CONSTANT_METHODREF = 10;
    static final int CONSTANT_INTERFACE_METHODREF = 11;
    static final int CONSTANT_STRING = 8;
    static final int CONSTANT_INTEGER = 3;
    static final int CONSTANT_FLOAT = 4;
    static final int CONSTANT_LONG = 5;
    static final int CONSTANT_DOUBLE = 6;
    static final int CONSTANT_NAME_AND_TYPE = 12;
    static final int CONSTANT_UTF8 = 1;
    static final int CONSTANT_METHOD_HANDLE = 15;
    static final int CONSTANT_METHOD_TYPE = 16;
    static final int CONSTANT_INVOKE_DYNAMIC = 18;

    static Constant read(DataInput input) throws IOException {
        int tag = input.readUnsignedByte();
//        ConstantType type = ConstantType.fromValue(tag);
        System.out.println(tag);
        switch (tag) {
            case CONSTANT_UTF8:
                return Utf8Constant.read(input);
            case CONSTANT_CLASS:
                return ClassConstant.read(input);
            case CONSTANT_FIELDREF:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_METHODREF:
                return MethodRefConstant.read(input);
            case CONSTANT_INTERFACE_METHODREF:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_STRING:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_INTEGER:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_FLOAT:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_LONG:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_DOUBLE:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_NAME_AND_TYPE:
                return NameAndTypeConstant.read(input);
            case CONSTANT_METHOD_HANDLE:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_METHOD_TYPE:
                throw new UnsupportedOperationException("Not yet implemented");
            case CONSTANT_INVOKE_DYNAMIC:
                throw new UnsupportedOperationException("Not yet implemented");
        }

       return null;// throw new IllegalArgumentException("Not yet implemented " + tag);
    }
}
