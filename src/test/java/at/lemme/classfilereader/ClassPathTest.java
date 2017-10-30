package at.lemme.classfilereader;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassPathTest {
    @Test
    public void test() throws IOException {
        // GIVEN
        int cnt = 0;
        for (String classpathEntry : System.getProperty("java.class.path").split(System.getProperty("path.separator"))) {
            if (classpathEntry.endsWith(".jar")) {

                System.out.println("Proceccing jar file: "+classpathEntry);
                JarFile jar = new JarFile(new File(classpathEntry));
                Enumeration<JarEntry> entries = jar.entries();
                JarEntry entry;

                while( entries.hasMoreElements()) {
                    entry = entries.nextElement();
                    if(entry.getName().endsWith(".class")) {
                        // WHEN
                        InputStream is = jar.getInputStream(entry);
                        ClassFile.read(is);
                        is.close();
                        // THEN - read successful
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
