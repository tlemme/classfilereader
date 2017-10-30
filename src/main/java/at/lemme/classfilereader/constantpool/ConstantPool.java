package at.lemme.classfilereader.constantpool;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_DOUBLE;
import static at.lemme.classfilereader.constantpool.Constant.Type.CONSTANT_LONG;

public class ConstantPool {

    private final int count;
    private final Constant[] constants;

    public ConstantPool(int count, final Constant[] constants) {
        this.count = count;
        this.constants = constants;
    }

    public static ConstantPool read(DataInput input) throws IOException {
        int count = input.readUnsignedShort();
        Constant[] constants = new Constant[count];
        for (int i = 1; i < count; i++) {
            constants[i] = Constant.read(input);
            if(constants[i].getType() == CONSTANT_LONG || constants[i].getType() == CONSTANT_DOUBLE){
                i++;
            }
        }

        return new ConstantPool(count, constants);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Constant Pool:\n");
        for (int i = 0; i < constants.length; i++) {
            sb.append("-").append(String.format("%3d ", i));
            if (constants[i] != null) {
                sb.append(constants[i].toString(constants));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Constant[] getConstants() {
        return constants;
    }

    public Constant get(int index){
        return constants[index];
    }

    public List<Constant> byType(Constant.Type type) {
        return Arrays.stream(constants)
                .filter(Objects::nonNull)
                .filter(c->type.equals(c.getType()))
                .collect(Collectors.toList());
    }
}
