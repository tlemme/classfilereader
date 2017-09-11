package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;

public class ConstantPool {

    private final int count;
    private final Constant[] constants;

    public ConstantPool(int count, final Constant[] constants) {
        this.count = count;
        this.constants = constants;
    }

    public static ConstantPool read(DataInput input) throws IOException {
        int count = input.readUnsignedShort();
        System.out.println(count);

        Constant[] constants = new Constant[count];
        for (int i = 1; i < count; i++) {
            constants[i] = Constant.read(input);
        }

        return new ConstantPool(count, constants);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Constant Pool:\n");
        for (int i = 0; i < constants.length; i++) {

            sb.append("-").append(String.format("%3d ", i))
                    .append(constants[i]).append("\n");
        }
        return sb.toString();
    }
}
