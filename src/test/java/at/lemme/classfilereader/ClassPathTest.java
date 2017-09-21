package at.lemme.classfilereader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class ClassPathTest {
    @Test
    public void test() throws IOException {
        // GIVEN
        int cnt = 0;
        // WHEN

        //THEN
        for (String classpathEntry : System.getProperty("java.class.path").split(System.getProperty("path.separator"))) {
            if (classpathEntry.endsWith(".jar")) {

                System.out.println("########"+classpathEntry);
                JarFile jar = new JarFile(new File(classpathEntry));

                Enumeration<JarEntry> entries = jar.entries();


                JarEntry entry;
                while( entries.hasMoreElements()) {
                    entry = entries.nextElement();

                    if(entry.getName().endsWith(".class")
//                            && !entry.getName().contains("AccessBridge")
//                            && !entry.getName().contains("AccessBridge")
                            ) {
                        //System.out.println(entry);
                        ClassFile.read(jar.getInputStream(entry));
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    private void listFiles(File root) {

        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                listFiles(file);
            } else {
                String name = file.getName();
                System.out.println(name);
                // Check if it's a .class file or a .jar file and handle accordingly.
            }
        }
    }

}
