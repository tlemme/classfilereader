package at.lemme.classfilereader.samples;

public interface InterfaceExample {
    final int CONSTANT_INT = 42;
    final long CONSTANT_LONG = 42;
    final double CONSTANT_DOUBLE = 42;
    final float CONSTANT_FLOAT = 42;

    default int getValue(){
        getString();
        return CONSTANT_INT;
    }

    String getString();
}
