package decorator;

interface Shape {

    String info();
}

class Circle implements Shape1 {

    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public String getInfo() {
        return "A Circle with a radius of " + radius;
    }
}

class Square implements Shape1 {

    private int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String getInfo() {
        return "A square with a side length of " + sideLength;
    }
}

class ColorDecorator implements Shape1 {

    private Shape1 shape;
    private String color;

    public ColorDecorator(Shape1 shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + ", and color " + color;
    }
}

class TransparencyDecorator implements Shape1 {

    private Shape1 shape;
    private float transparency;

    public TransparencyDecorator(Shape1 shape, float transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + ", and transparency " + transparency;
    }
}

// Dynamic decorator at runtime
public class DynamicDecoratorDemo {

    public static void main(String[] args) {
        Shape1 greenSquare = new ColorDecorator(new Square(5), "green");
        System.out.println(greenSquare.getInfo());

        var transparentGreenSquare = new TransparencyDecorator(greenSquare, 1.0f);
        System.out.println(transparentGreenSquare.getInfo());

        Shape1 transparentCircle = new TransparencyDecorator(new Circle(8f), .5f);
        System.out.println(transparentCircle.getInfo());
    }

}
