package module8;

public class Main {
    public static void main(String[] args) {
        Shape[] objArray = {new Quad(), new Circle(), new Diamond(), new Rectangle(), new Triangle()};
        PrintShape print = new PrintShape();
        for(Shape obj:objArray){
            print.printer(obj);
        }
    }
}
