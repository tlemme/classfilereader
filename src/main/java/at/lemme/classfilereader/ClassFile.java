package at.lemme.classfilereader;

import at.lemme.classfilereader.constantpool.ConstantPool;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFile {

    private final Version version;
    private final ConstantPool constantPool;

    private ClassFile(Version version, ConstantPool constantPool){
        this.version = version;
        this.constantPool = constantPool;
    }

    public static ClassFile read(InputStream is) throws IOException {
        DataInput input = new DataInputStream(is);

        readMagic(input);
        Version version = readVersion(input);
        ConstantPool constantPool = ConstantPool.read(input);
        return new ClassFile(version, constantPool);
    }

    private static void readMagic(DataInput in) throws IOException {
        int magic = in.readInt();
        if(magic != 0xCAFEBABE){
            throw new IllegalArgumentException("Magic is expected to be 0xCAFEBABE. " +
                    "Argument is not a Java Class File!");
        }
    }

    private static Version readVersion(DataInput input) throws IOException {
        int minorVersion = input.readUnsignedShort();
        int majorVersion = input.readUnsignedShort();
        return Version.of(majorVersion, minorVersion);
    }

    public Version getVersion() {
        return version;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }
}
