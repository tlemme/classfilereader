package at.lemme.classfilereader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


public class TestMagic {

    @Test
    public void test() throws IOException {
        // GIVEN
        InputStream is = TestMagic.class.getResourceAsStream("/EmptyClass.class");

        // WHEN
        ClassFile classFile = ClassFile.read(is);

        // THEN
        assertThat(classFile).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAClass() throws IOException {
        // GIVEN
        InputStream is = TestMagic.class.getResourceAsStream("/notAClass.txt");

        // WHEN
        ClassFile classFile = ClassFile.read(is);

        //THEN
        fail("We must not reach this code.");
    }
}
