import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle
 * Class that extends IGraphicObject and represents a rectangle object
 */
public class Rectangle extends IGraphicObject {
    /**
     * List of lines of rectangle
     */
    public List<Line> objects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param line1 The first line of rectangle
     * @param line2 The second line of rectangle
     * @param line3 The third line of rectangle
     * @param line4 The forth line of rectangle
     */
    public Rectangle(Line line1, Line line2, Line line3, Line line4){
        objects.add(line1);
        objects.add(line2);
        objects.add(line3);
        objects.add(line4);
    }

    /**
     * Draw a rectangle
     */
    @Override
    public void draw() {
        for (IGraphicObject obj: objects) {
            obj.draw();
        }

        System.out.println("The rectangle was drawn");
    }
}


