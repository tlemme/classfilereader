# A Java Class File Format Reader

The source code for my series of blog posts [Learning the Java Class File Format](http://webcode.lemme.at/2017/09/06/the-java-class-file-format/).

* [The Java Class File Format – an Overview](http://webcode.lemme.at/2017/09/13/the-java-class-file-format-an-overview/)
* [0xCAFEBABE – The Java Class File Magic Number](http://webcode.lemme.at/2017/09/20/0xcafebabe-the-java-class-file-magic-number/)

## Usage

```java
InputStream in = ... 
ClassFile classFile = ClassFile.read(in);

classFile.getVersion();
```