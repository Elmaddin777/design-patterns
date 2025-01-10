package proxy;

interface Image {

    void display();

}

class RealImage implements Image {

    private final String imageName;

    public RealImage(String imageName) {
        this.imageName = imageName;
        loadImageFromDisc(); // Expensive process !!!
    }

    private void loadImageFromDisc() {
        System.out.println("Loading " + this.imageName + " from disc");
    }

    @Override
    public void display() {
        System.out.println("Displaying image - " + this.imageName);
    }

}

class ProxyImage implements Image {

    private RealImage realImage;
    private final String imageName;

    public ProxyImage(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void display() {
        if (this.realImage == null) {
            this.realImage = new RealImage(this.imageName);
        }

        this.realImage.display();
    }

}

class ImageProxyDemo {

    public static void main(String[] args) {
        var image_1 = new ProxyImage("cats.jpg");
        var image_2 = new ProxyImage("birds.png");

        image_1.display();
        image_2.display();
        image_2.display();
    }

}