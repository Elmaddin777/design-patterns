package prototype;

class Point {
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line {

    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        Point pointStart = new Point(this.start.x, this.start.y);
        Point pointEnd = new Point(this.end.x, this.end.y);
        return new Line(pointStart, pointEnd);
    }

}
