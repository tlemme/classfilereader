package at.lemme.classfilereader;

import at.lemme.classfilereader.constantpool.ConstantPool;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFile {

    private int majorVersion;
    private int minorVersion;
    private final ConstantPool constantPool;

    private ClassFile(int majorVersion, int minorVersion, ConstantPool constantPool){
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.constantPool = constantPool;
    }

    public static ClassFile read(InputStream is) throws IOException {
        DataInput input = new DataInputStream(is);

        readMagic(input);

        int minorVersion = input.readUnsignedShort();
        int majorVersion = input.readUnsignedShort();

        ConstantPool constantPool = ConstantPool.read(input);

        return new ClassFile(majorVersion, minorVersion, constantPool);
    }

    private static void readMagic(DataInput in) throws IOException {
        int magic = in.readInt();
        if(magic != 0xCAFEBABE){
            throw new IllegalArgumentException("Magic is expected to be 0xCAFEBABE. " +
                    "Argument is not a Java Class File!");
        }
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }
}
