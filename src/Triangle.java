import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle
 * Class that extends IGraphicObject and represents a triangle object
 */
public class Triangle extends IGraphicObject {
    /**
     * List of lines of rectangle
     */
    public List<Line> objects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param line1 The first line of triangle
     * @param line2 The second line of triangle
     * @param line3 The third line of triangle
     */
    public Triangle(Line line1, Line line2, Line line3){
        objects.add(line1);
        objects.add(line2);
        objects.add(line3);
    }

    /**
     * Draw a triangle
     */
    @Override
    public void draw() {
        for (IGraphicObject obj: objects) {
            obj.draw();
        }

        System.out.println("The triangle was drawn");
    }
}

