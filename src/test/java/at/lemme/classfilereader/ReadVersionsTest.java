package at.lemme.classfilereader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ReadVersionsTest {

    @Parameters(name = "Class File Version {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1_2", Version.JAVA_1_2},
                {"1_3", Version.JAVA_1_3},
                {"1_4", Version.JAVA_1_4},
                {"5", Version.JAVA_5},
                {"6", Version.JAVA_6},
                {"7", Version.JAVA_7},
                {"8", Version.JAVA_8},
                {"9", Version.JAVA_9}
        });
    }

    @Parameter(0)
    public String versionSuffix;

    @Parameter(1)
    public Version version;

    @Test
    public void testReadVersion() throws IOException {
        // GIVEN
        InputStream in = ReadVersionsTest.class.getResourceAsStream("/versions/SampleClass" + versionSuffix + ".class");

        // WHEN
        ClassFile classFile = ClassFile.read(in);

        //THEN
        assertThat(classFile.getVersion()).isEqualTo(version);
    }

}
