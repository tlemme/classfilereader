package at.lemme.classfilereader.constantpool;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static at.lemme.classfilereader.constantpool.Constant.Type.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;


public class ConstantTest {

    @Test
    public void testConstantUtf8() throws IOException {
        // GIVEN
        String testString = createLongString(50000);
        ByteBuffer buffer = ByteBuffer.allocate(testString.getBytes().length + 3);
        buffer.put((byte) CONSTANT_UTF8.value);
        buffer.putShort((short) testString.length());
        buffer.put(testString.getBytes(UTF_8));
        DataInput is = buffterToDataInput(buffer);

        // WHEN
        ConstantUtf8 c = (ConstantUtf8) Constant.read(is);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_UTF8);
        assertThat(c.getString()).isEqualTo(testString);
    }

    @Test
    public void testConstantInteger() throws IOException {
        // GIVEN
        DataInput inputZero = createIntegerInput(0);
        DataInput inputMin = createIntegerInput(Integer.MIN_VALUE);
        DataInput inputMax = createIntegerInput(Integer.MAX_VALUE);

        // WHEN
        ConstantInteger cZero = (ConstantInteger) Constant.read(inputZero);
        ConstantInteger cMin = (ConstantInteger) Constant.read(inputMin);
        ConstantInteger cMax = (ConstantInteger) Constant.read(inputMax);

        //THEN
        assertThat(cZero.getType()).isEqualTo(CONSTANT_INTEGER);
        assertThat(cZero.getValue()).isEqualTo(0);
        assertThat(cMin.getType()).isEqualTo(CONSTANT_INTEGER);
        assertThat(cMin.getValue()).isEqualTo(Integer.MIN_VALUE);
        assertThat(cMax.getType()).isEqualTo(CONSTANT_INTEGER);
        assertThat(cMax.getValue()).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void testConstantFloat() throws IOException {
        // GIVEN
        DataInput inputZero = createFloatInput(0);
        DataInput inputMin = createFloatInput(Float.MIN_VALUE);
        DataInput inputMax = createFloatInput(Float.MAX_VALUE);

        // WHEN
        ConstantFloat cZero = (ConstantFloat) Constant.read(inputZero);
        ConstantFloat cMin = (ConstantFloat) Constant.read(inputMin);
        ConstantFloat cMax = (ConstantFloat) Constant.read(inputMax);

        //THEN
        assertThat(cZero.getType()).isEqualTo(CONSTANT_FLOAT);
        assertThat(cZero.getValue()).isEqualTo(0);
        assertThat(cMin.getType()).isEqualTo(CONSTANT_FLOAT);
        assertThat(cMin.getValue()).isEqualTo(Float.MIN_VALUE);
        assertThat(cMax.getType()).isEqualTo(CONSTANT_FLOAT);
        assertThat(cMax.getValue()).isEqualTo(Float.MAX_VALUE);
    }

    @Test
    public void testConstantLong() throws IOException {
        // GIVEN
        DataInput inputZero = createLongInput(0);
        DataInput inputMin = createLongInput(Long.MIN_VALUE);
        DataInput inputMax = createLongInput(Long.MAX_VALUE);

        // WHEN
        ConstantLong cZero = (ConstantLong) Constant.read(inputZero);
        ConstantLong cMin = (ConstantLong) Constant.read(inputMin);
        ConstantLong cMax = (ConstantLong) Constant.read(inputMax);

        //THEN
        assertThat(cZero.getType()).isEqualTo(CONSTANT_LONG);
        assertThat(cZero.getValue()).isEqualTo(0);
        assertThat(cMin.getType()).isEqualTo(CONSTANT_LONG);
        assertThat(cMin.getValue()).isEqualTo(Long.MIN_VALUE);
        assertThat(cMax.getType()).isEqualTo(CONSTANT_LONG);
        assertThat(cMax.getValue()).isEqualTo(Long.MAX_VALUE);
    }

    @Test
    public void testConstantDouble() throws IOException {
        // GIVEN
        DataInput inputZero = createDoubleInput(0);
        DataInput inputMin = createDoubleInput(Double.MIN_VALUE);
        DataInput inputMax = createDoubleInput(Double.MAX_VALUE);

        // WHEN
        ConstantDouble cZero = (ConstantDouble) Constant.read(inputZero);
        ConstantDouble cMin = (ConstantDouble) Constant.read(inputMin);
        ConstantDouble cMax = (ConstantDouble) Constant.read(inputMax);

        //THEN
        assertThat(cZero.getType()).isEqualTo(CONSTANT_DOUBLE);
        assertThat(cZero.getValue()).isEqualTo(0);
        assertThat(cMin.getType()).isEqualTo(CONSTANT_DOUBLE);
        assertThat(cMin.getValue()).isEqualTo(Double.MIN_VALUE);
        assertThat(cMax.getType()).isEqualTo(CONSTANT_DOUBLE);
        assertThat(cMax.getValue()).isEqualTo(Double.MAX_VALUE);
    }

    @Test
    public void testConstantClass() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(3);
        buffer.put((byte) CONSTANT_CLASS.value);
        buffer.putShort((short) 10000);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantClass c = (ConstantClass) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_CLASS);
        assertThat(c.getNameIndex()).isEqualTo(10000);
    }

    @Test
    public void testConstantString() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(3);
        buffer.put((byte) CONSTANT_STRING.value);
        buffer.putShort((short) 10000);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantString c = (ConstantString) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_STRING);
        assertThat(c.getStringIndex()).isEqualTo(10000);
    }

    @Test
    public void testConstantFieldRef() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_FIELDREF.value);
        buffer.putShort((short) 10000);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantFieldRef c = (ConstantFieldRef) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_FIELDREF);
        assertThat(c.getClassIndex()).isEqualTo(10000);
        assertThat(c.getNameAndTypeIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantMethodRef() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_METHODREF.value);
        buffer.putShort((short) 10000);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantMethodRef c = (ConstantMethodRef) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_METHODREF);
        assertThat(c.getClassIndex()).isEqualTo(10000);
        assertThat(c.getNameAndTypeIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantInterfaceMethodRef() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_INTERFACE_METHODREF.value);
        buffer.putShort((short) 10000);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantInterfaceMethodRef c = (ConstantInterfaceMethodRef) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_INTERFACE_METHODREF);
        assertThat(c.getClassIndex()).isEqualTo(10000);
        assertThat(c.getNameAndTypeIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantNameAndType() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_NAME_AND_TYPE.value);
        buffer.putShort((short) 10000);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantNameAndType c = (ConstantNameAndType) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_NAME_AND_TYPE);
        assertThat(c.getNameIndex()).isEqualTo(10000);
        assertThat(c.getDescriptorIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantMethodHandle() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.put((byte) CONSTANT_METHOD_HANDLE.value);
        buffer.put((byte) 9);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantMethodHandle c = (ConstantMethodHandle) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_METHOD_HANDLE);
        assertThat(c.getReferenceKind()).isEqualTo(9);
        assertThat(c.getReferenceIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantMethodType() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(100000);
        buffer.put((byte) CONSTANT_METHOD_TYPE.value);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantMethodType c = (ConstantMethodType) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_METHOD_TYPE);
        assertThat(c.getDescriptorIndex()).isEqualTo(10001);
    }

    @Test
    public void testConstantInvokeDynamic() throws IOException {
        // GIVEN
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_INVOKE_DYNAMIC.value);
        buffer.putShort((short) 10000);
        buffer.putShort((short) 10001);
        DataInput input = buffterToDataInput(buffer);

        // WHEN
        ConstantInvokeDynamic c = (ConstantInvokeDynamic) Constant.read(input);

        //THEN
        assertThat(c.getType()).isEqualTo(CONSTANT_INVOKE_DYNAMIC);
        assertThat(c.getBootstrapMethodAttrIndex()).isEqualTo(10000);
        assertThat(c.getNameAndTypeIndex()).isEqualTo(10001);
    }

    private DataInput createIntegerInput(int value) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_INTEGER.value);
        buffer.putInt(value);
        return buffterToDataInput(buffer);
    }

    private DataInput createFloatInput(float value) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put((byte) CONSTANT_FLOAT.value);
        buffer.putFloat(value);
        return buffterToDataInput(buffer);
    }

    private DataInput createLongInput(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        buffer.put((byte) CONSTANT_LONG.value);
        buffer.putLong(value);
        return buffterToDataInput(buffer);
    }

    private DataInput createDoubleInput(double value) {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        buffer.put((byte) CONSTANT_DOUBLE.value);
        buffer.putDouble(value);
        return buffterToDataInput(buffer);
    }

    private DataInput buffterToDataInput(ByteBuffer buffer) {
        return new DataInputStream(new ByteArrayInputStream(buffer.array()));
    }

    private String createLongString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append("x");
        }
        return sb.toString();
    }

}
