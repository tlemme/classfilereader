package at.lemme.classfilereader;

import at.lemme.classfilereader.samples.ClassExample;

import java.io.IOException;
import java.io.InputStream;

public class PrintClassFile {

    public static void main(String[] args) throws IOException {
        String resName = ClassExample.class.getName().replaceAll("\\.", "/") + ".class";
        InputStream is = ReadClassFile.class.getResourceAsStream("/SampleClass7.class");
        String byteString = bytesToString(is, 16);
        System.out.println(byteString);
    }

    private static String bytesToString(InputStream is, int bytesInARow) throws IOException {
        byte[] buffer = new byte[bytesInARow];
        int length = 0;
        StringBuilder sb = new StringBuilder();
        while((length = is.read(buffer)) > 0){
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X ", buffer[i]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}