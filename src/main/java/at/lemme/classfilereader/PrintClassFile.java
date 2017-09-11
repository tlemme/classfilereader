package at.lemme.classfilereader;

import java.io.IOException;
import java.io.InputStream;

public class PrintClassFile {

    public static void main(String[] args) throws IOException {
        InputStream is = PrintClassFile.class.getResourceAsStream("/EmptyClass.class");
        String byteString = bytesToString(is, 16);
        System.out.println(byteString);
    }

    private static String bytesToString(InputStream is, int bytesInARow) throws IOException {
        byte[] buffer = new byte[bytesInARow];
        int length = 0;
        StringBuilder sb = new StringBuilder();
        while((length = is.read(buffer)) > 0){
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%2X ", buffer[i]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}