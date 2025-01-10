package proxy;

interface File {
    void read();
}

class TextFile implements File {

    private final String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
        loadFileFromDisc();
    }

    @Override
    public void read() {
        System.out.println("Reading file: " + fileName);
    }

    private void loadFileFromDisc() {
        System.out.println("Loading file " + fileName + "...");
    }

}

class TextFileProxy implements File {
    private final String fileName;
    private TextFile textFile;

    public TextFileProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void read() {
        if (textFile == null) {
            textFile = new TextFile(fileName);
        }
        textFile.read();
    }

}

public class FileDemo {

    public static void main(String[] args) {
        File textFile = new TextFileProxy("sometext.txt");
        textFile.read();
        textFile.read();
    }

}
