package adapter;

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle{
    private final Square square;

    public SquareToRectangleAdapter(Square square)
    {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight(){
        return square.side;
    }
}

class SquareToRectangleAdapterDemo {
    public static void main(String[] args) {
        Rectangle rectangle =  new SquareToRectangleAdapter(new Square(5));
        System.out.println(rectangle.getArea());
    }
}