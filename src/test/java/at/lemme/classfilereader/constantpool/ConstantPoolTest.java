package at.lemme.classfilereader.constantpool;

import at.lemme.classfilereader.ClassFile;
import at.lemme.classfilereader.samples.EmptyClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_METHODREF;
import static org.assertj.core.api.Assertions.assertThat;

public class ConstantPoolTest {

    @Test
    public void testEmptyClassConstants() throws IOException {
        // GIVEN
        String resName = EmptyClass.class.getName().replaceAll("\\.", "/") + ".class";
        InputStream is = getClass().getResourceAsStream("/" + resName);

        // WHEN
        ClassFile cf = ClassFile.read(is);

        // THEN
        // There is exactly one MethodRef entry - the default constructor inherited from java.lang.object
        ConstantPool cp = cf.getConstantPool();
        // Arrays.stream(cp.getConstants()).forEach(System.out::println);

        ConstantMethodRef constructor = (ConstantMethodRef) cp.byType(CONSTANT_METHODREF).get(0);

        ConstantClass constructorClass = (ConstantClass) cp.get(constructor.getClassIndex());
        ConstantUtf8 className = (ConstantUtf8) cp.get(constructorClass.getNameIndex());

        ConstantNameAndType nameAndType = (ConstantNameAndType) cp.get(constructor.getNameAndTypeIndex());
        ConstantUtf8 methodName = (ConstantUtf8) cp.get(nameAndType.getNameIndex());
        ConstantUtf8 methodDescriptor = (ConstantUtf8) cp.get(nameAndType.getDescriptorIndex());

        assertThat(className.getString()).isEqualTo("java/lang/Object");
        assertThat(methodName.getString()).isEqualTo("<init>");
        assertThat(methodDescriptor.getString()).isEqualTo("()V");
    }
}
