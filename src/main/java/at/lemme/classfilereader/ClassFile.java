package at.lemme.classfilereader;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFile {

    private ClassFile(){
    }

    public static ClassFile read(InputStream is) throws IOException {
        DataInput input = new DataInputStream(is);

        readMagic(input);

        return new ClassFile();
    }

    private static void readMagic(DataInput in) throws IOException {
        int magic = in.readInt();
        if(magic != 0xCAFEBABE){
            throw new IllegalArgumentException("Magic is expected to be 0xCAFEBABE. " +
                    "Argument is not a Java Class File!");
        }
    }
}
