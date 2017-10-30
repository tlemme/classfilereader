package at.lemme.classfilereader;

public enum Version {
    JAVA_1_1(45, 3),
    JAVA_1_2(46, 0),
    JAVA_1_3(47, 0),
    JAVA_1_4(48, 0),
    JAVA_5(49, 0),
    JAVA_6(50, 0),
    JAVA_7(51, 0),
    JAVA_8(52, 0),
    JAVA_9(53, 0);

    public final int major;
    public final int minor;

    Version(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public static Version of(int major, int minor) {
        for (Version v : Version.values()) {
            if (v.major == major && v.minor == minor) {
                return v;
            }
        }
        throw new IllegalArgumentException("No matching Java Class File version " +
                "for given major/minor version found: " + major + "/" + minor);
    }
}
