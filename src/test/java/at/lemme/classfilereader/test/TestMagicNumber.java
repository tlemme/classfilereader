package at.lemme.classfilereader.test;

import at.lemme.classfilereader.ClassFile;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


public class TestMagicNumber {

    @Test
    public void test() throws IOException {
        // GIVEN
        InputStream is = TestMagicNumber.class.getResourceAsStream("/EmptyClass.class");

        // WHEN
        ClassFile classFile = ClassFile.read(is);

        // THEN
        assertThat(classFile).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAClass() throws IOException {
        // GIVEN
        InputStream is = TestMagicNumber.class.getResourceAsStream("/notAClass.txt");

        // WHEN
        ClassFile classFile = ClassFile.read(is);

        //THEN
        fail("We must not reach this code.");
    }
}
