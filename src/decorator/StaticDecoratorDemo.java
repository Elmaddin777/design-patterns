package decorator;

interface Shape1 {
    String getInfo();
}

class Rectangle implements Shape1 {

    private int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int height;

    @Override
    public String getInfo() {
        return "A Rectangle with width " + width + " and height " + height;
    }
}

class ColourDecorator<T extends Shape1> implements Shape1 {

    private T shape;
    private String colour;

    public ColourDecorator(T shape, String colour) {
        this.shape = shape;
        this.colour = colour;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + ", with colour " + colour;
    }
}

class TransparentDecorator<T extends Shape1> implements Shape1 {

    private T shape;
    private float transparency;

    public TransparentDecorator(T shape, float transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + ", with transparency " + transparency;
    }
}

// Static decorator - compile time
public class StaticDecoratorDemo {

    public static void main(String[] args) {
        // new rectangle
        var rectangle = new Rectangle(3, 4);

        // give color
        var blueRectangle = new ColourDecorator<>(rectangle, "blue");

        // give transparency
        var transparentBlueRectangle = new TransparentDecorator<>(blueRectangle, .5f);

        System.out.println(transparentBlueRectangle.getInfo());

    }

}
