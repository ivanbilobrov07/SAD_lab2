/**
 * Line
 * Class that extends IGraphicObject and represents a line object
 */
public class Line extends IGraphicObject{
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    /**
     * Constructor
     *
     * @param x1 x coordinate of the first point
     * @param y1 y coordinate of the first point
     * @param x2 x coordinate of the second point
     * @param y2 y coordinate of the second point
     */
    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Draw a line
     */
    @Override
    public void draw() {
        System.out.println("The line was drawn");
    }
}
