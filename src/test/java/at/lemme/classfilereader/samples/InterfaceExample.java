package at.lemme.classfilereader.samples;

public interface InterfaceExample {
    final int CONSTANT_VALUE = 42;

    default int getValue(){
        return CONSTANT_VALUE;
    }

    String getString();
}
