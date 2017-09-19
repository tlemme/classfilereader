package at.lemme.classfilereader;

import at.lemme.classfilereader.constantpool.Constant;
import at.lemme.classfilereader.constantpool.ConstantUtf8;
import at.lemme.classfilereader.constantpool.Type;
import at.lemme.classfilereader.samples.InterfaceExample;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestConstantPool {

    @Test
    public void testPoolHasEntries() throws IOException {
        String resName = InterfaceExample.class.getName().replaceAll("\\.", "/") + ".class";
        InputStream is = ReadClassFile.class.getResourceAsStream("/"+resName);
        ClassFile cf = ClassFile.read(is);
//        Assertions.assertThat(cf.getConstantPool().)
        cf.getConstantPool().findByType(Type.CONSTANT_UTF8).stream().anyMatch(c->"getValue".equals(((ConstantUtf8)c).getString()));
    }

}
