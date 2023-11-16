# images-handling

```bash
  Handling image with JAVA
```

## Jar
```bash
    jar cvfe image.jar image.ImageMain images -C classes image
```
## Compilation

```bash
  - Compilation of the test classe
  javac -classpath junit-console.jar:classes test/TestImage.java
  - Compilation of the image classe
  javac -cp src src/image/*.java -d classes
  javac -cp src src/image/color/GrayColor.java -d classes
```

## Execution

```bash
  java -jar junit-console.jar -classpath test:classes -scan-classpath 
  - Execution of classe ImageExampleMain and ImageMain
  java -classpath classes image.ImageExampleMain
  java -classpath classes image.ImageMain /images/lamp.pgm
```

## Docs 

```bash
  javadoc -sourcepath src -subpackages image -d docs
```
## Authors

- [theophane.legrand.etu@univ-lille.fr](mailto:theophane.legrand.etu@univ-lille.fr)


