package at.lemme.classfilereader.constantpool;

public enum Type {

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

    public static Type fromValue(int value) {
        for (Type c : values()) {
            if (c.value == value) {
                return c;
            }
        }
        throw new IllegalArgumentException("No Constant Pool Type for value " + value);
    }

}
