public class Main {
    public static void main(String[] args) {
        GraphicObjectFactory graphicObjectFactory = new GraphicObjectFactory();

        Line trLine1 = (Line) graphicObjectFactory.getLine(0, 0, 0, 5);
        Line trLine2 = (Line) graphicObjectFactory.getLine(0, 0, 3, 0);
        Line trLine3 = (Line) graphicObjectFactory.getLine(0, 5, 3, 0);

        Line recLine1 = (Line) graphicObjectFactory.getLine(0, 0, 0, 5);
        Line recLine2 = (Line) graphicObjectFactory.getLine(0, 0, 10, 0);
        Line recLine3 = (Line) graphicObjectFactory.getLine(0, 5, 10, 5);
        Line recLine4 = (Line) graphicObjectFactory.getLine(10, 5, 10, 0);

        Triangle tr = (Triangle) graphicObjectFactory.getTriangle(trLine1, trLine2, trLine3);
        Rectangle rec = (Rectangle) graphicObjectFactory.getRectangle(recLine1, recLine2, recLine3, recLine4);

        tr.draw();
        rec.draw();

        System.out.println(trLine1 == recLine1);
    }
}