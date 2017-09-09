package at.lemme.classfilereader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class TestMagic {
    @Test
    public void test() throws IOException {
        InputStream is = TestMagic.class.getResourceAsStream("/EmptyClass.class");
        ClassFile classFile = ClassFile.read(is);
    }
    @Test(expected = Exception.class)
    public void testNotAClass() throws IOException {
        InputStream is = TestMagic.class.getResourceAsStream("/notAClass.txt");
        ClassFile classFile = ClassFile.read(is);
    }

}
