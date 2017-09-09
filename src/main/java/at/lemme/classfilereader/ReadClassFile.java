package at.lemme.classfilereader;

import java.io.IOException;
import java.io.InputStream;

public class ReadClassFile {

    public static void main(String[] args) throws IOException {
        InputStream is = ReadClassFile.class.getResourceAsStream("/EmptyClass.class");
        ClassFile classFile = ClassFile.read(is);

    }



}