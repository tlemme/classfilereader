package at.lemme.classfilereader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class ReadClassFile implements AutoCloseable{

    public static void main(String[] args) throws IOException {
        try(InputStream is = ReadClassFile.class.getResourceAsStream("/EmptyClass.class");) {
            ClassFile classFile = ClassFile.read(is);

            System.out.println(classFile.getConstantPool());
        }
    }


    @Override
    public void close() throws Exception {

    }
}