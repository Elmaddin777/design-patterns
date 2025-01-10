package composite;

import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemComponent {

    void display();

}

// Leaf
class FileComponent implements FileSystemComponent {

    private String name;

    public FileComponent(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(" File: " + this.name);
    }

}

// Composite
class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + this.name);
        components.forEach(component -> component.display());
    }

}

public class FileSystemDemo {

    public static void main(String[] args) {
        var rootFolder = new Folder("ROOT");
        var musicFolder = new Folder("Music");
        var videoFolder = new Folder("Video");

        var musicComponent = new FileComponent("somemusic.mp3");
        var videoComponent = new FileComponent("somevideo.mp4");

        musicFolder.addComponent(musicComponent);
        videoFolder.addComponent(videoComponent);

        rootFolder.addComponent(musicFolder);
        rootFolder.addComponent(videoFolder);

        rootFolder.display();
    }

}
