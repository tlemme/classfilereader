package at.lemme.classfilereader;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> m = new HashMap<>();

        byte[] x = (byte[])m.get("lala");
        System.out.println(x);
    }
}
