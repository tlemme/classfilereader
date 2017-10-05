package at.lemme.classfilereader;

import at.lemme.classfilereader.constantpool.Constant;
import at.lemme.classfilereader.constantpool.ConstantUtf8;
import at.lemme.classfilereader.constantpool.Type;
import at.lemme.classfilereader.samples.ClassExample;
import at.lemme.classfilereader.samples.InterfaceExample;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestConstantPool {

    @Test
    public void testInterfaceWithoutErrors() throws IOException {
        String resName = InterfaceExample.class.getName().replaceAll("\\.", "/") + ".class";
        InputStream is = ReadClassFile.class.getResourceAsStream("/" + resName);
        ClassFile cf = ClassFile.read(is);
//        Assertions.assertThat(cf.getConstantPool().)
//        cf.getConstantPool().findByType(Type.CONSTANT_UTF8).stream().anyMatch(c->"getValue".equals(((ConstantUtf8)c).getString()));
    }

    @Test
    public void testClassWithoutErrors() throws IOException {
        String resName = ClassExample.class.getName().replaceAll("\\.", "/") + ".class";
//        InputStream is = ReadClassFile.class.getResourceAsStream("/"+resName);
//        System.out.println(bytesToString(is, 16));
//        is.close();
        InputStream is = ReadClassFile.class.getResourceAsStream("/" + resName);
        ClassFile cf = ClassFile.read(is);
        Constant[] constants = cf.getConstantPool().getConstants();

        for (int i = 1; i < constants.length; i++) {
            System.out.println(i + ":" + (constants[i] == null? null:constants[i].toString(constants)));

        }
//        Assertions.assertThat(cf.getConstantPool().)
//        cf.getConstantPool().findByType(Type.CONSTANT_UTF8).stream().anyMatch(c->"getValue".equals(((ConstantUtf8)c).getString()));
    }

    private static String bytesToString(InputStream is, int bytesInARow) throws IOException {
        byte[] buffer = new byte[bytesInARow];
        int length = 0;
        StringBuilder sb = new StringBuilder();
        while ((length = is.read(buffer)) > 0) {
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X ", buffer[i]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
