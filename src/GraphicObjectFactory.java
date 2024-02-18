import java.util.*;

/**
 * GraphicObjectFactory
 * Class that uses flyweight pattern to create objects
 */
public class GraphicObjectFactory {
    /**
     * Graphic objects map
     */
    private Map<String, IGraphicObject> objectCache = new HashMap<>();

    /**
     * Constructor
     */
    public GraphicObjectFactory(){}

    /**
     * Get line
     *
     * @param x1 x coordinate of the first point
     * @param y1 y coordinate of the first point
     * @param x2 x coordinate of the second point
     * @param y2 y coordinate of the second point
     * @return Line object
     */
    public IGraphicObject getLine(int x1, int y1, int x2, int y2){
        String lineKey = "l-" + generateLineCordsKey(x1, y1, x2, y2);

        return getGraphicObject(lineKey);
    }

    /**
     * Get triangle
     *
     * @param line1 The first line of triangle
     * @param line2 The second line of triangle
     * @param line3 The third line of triangle
     * @return Triangle object
     */
    public IGraphicObject getTriangle(Line line1, Line line2, Line line3){
        String triangleKey = "t-" +
                generateLineCordsKey(line1.x1, line1.y1, line1.x2, line1.y2) +
                "," +
                generateLineCordsKey(line2.x1, line2.y1, line2.x2, line2.y2) +
                "," +
                generateLineCordsKey(line3.x1, line3.y1, line3.x2, line3.y2);

        return getGraphicObject(triangleKey);
    }

    /**
     * Get triangle
     *
     * @param line1 The first line of rectangle
     * @param line2 The second line of rectangle
     * @param line3 The third line of rectangle
     * @param line4 The forth line of rectangle
     * @return Triangle object
     */
    public IGraphicObject getRectangle(Line line1, Line line2, Line line3, Line line4){
        String rectangleKey = "r-" +
                generateLineCordsKey(line1.x1, line1.y1, line1.x2, line1.y2) +
                "," +
                generateLineCordsKey(line2.x1, line2.y1, line2.x2, line2.y2) +
                "," +
                generateLineCordsKey(line3.x1, line3.y1, line3.x2, line3.y2) +
                "," +
                generateLineCordsKey(line4.x1, line4.y1, line4.x2, line4.y2);

        return getGraphicObject(rectangleKey);
    }

    /**
     * Get IGraphicObject by its key
     *
     * @param key key of the object
     * @return IGraphicObject
     */

    private IGraphicObject getGraphicObject(String key){
        if(!objectCache.containsKey(key)){
            if(key.startsWith("l")){
                objectCache.put(key, generateLineFromKey(key));
            } else if(key.startsWith("t")) {
                objectCache.put(key, generateTriangleFromKey(key));
            } else if (key.startsWith("r")){
                objectCache.put(key, generateRectangleFromKey(key));
            }
        }

        return objectCache.get(key);
    }

    /**
     * Generate key of the line by its cords
     *
     * @param x1 x coordinate of the first point
     * @param y1 y coordinate of the first point
     * @param x2 x coordinate of the second point
     * @param y2 y coordinate of the second point
     * @return key
     */
    private String generateLineCordsKey(int x1, int y1, int x2, int y2) {
        return x1 + ";" + y1 + "|" + x2 + ";" + y2;
    }

    /**
     * Split a string to an array by delimeter
     *
     * @param str string to split
     * @param delimiter delimiter
     * @return Array of strings
     */
    private List<String> split(String str, String delimiter){
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter(delimiter);

        List<String> partsList = new ArrayList<>();
        while (scanner.hasNext()) {
            partsList.add(scanner.next());
        }

        return partsList;
    };

    /**
     * Generate a line from key
     *
     * @param key key
     * @return Line
     */
    private Line generateLineFromKey(String key){
        List<Integer> cords = new ArrayList<>();
        StringBuilder currentCord = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (Character.isDigit(ch)) {
                currentCord.append(ch);
            } else if (currentCord.length() > 0) {
                cords.add(Integer.valueOf(Integer.parseInt(currentCord.toString())));
                currentCord.setLength(0);
            }
        }

        if (currentCord.length() > 0) {
            cords.add(Integer.valueOf(Integer.parseInt(currentCord.toString())));
        }

        return new Line(cords.get(0), cords.get(1), cords.get(2), cords.get(3));
    }

    /**
     * Generate a triangle from key
     *
     * @param key key
     * @return Triangle
     */
    private Triangle generateTriangleFromKey(String key){
        List<String> linesCords = split(key, ",");
        List<Line> lines = new ArrayList<>();

        for (String cords: linesCords){
            lines.add(generateLineFromKey(cords));
        }

        return new Triangle(lines.get(0), lines.get(1), lines.get(2));
    }

    /**
     * Generate a rectangle from key
     *
     * @param key key
     * @return Rectangle
     */
    private Rectangle generateRectangleFromKey(String key){
        List<String> linesCords = split(key, ",");
        List<Line> lines = new ArrayList<>();

        for (String cords: linesCords){
            lines.add(generateLineFromKey(cords));
        }

        return new Rectangle(lines.get(0), lines.get(1), lines.get(2), lines.get(3));
    }
}
