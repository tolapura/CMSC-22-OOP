package SHAPES;

public class Main {

    public static void main(String[] args) {

        // tester for the first classes

    /*    Shape test = new Shape();
        Shape test2 = new Shape("blue", true);

        String color = test.getColor();
        String color2 = test2.getColor();

        System.out.println(color);
        System.out.println(color2);

        test.setColor("purple");
        test2.setColor("yellow");

        System.out.println(color); // expect purple
        System.out.println(color2); // expect yellow

        boolean checkTest = test.isFilled();
        boolean checkTest2 = test2.isFilled();

        System.out.println(checkTest);
        System.out.println(checkTest2);

        test.setFilled(true);
        test2.setFilled(true);

        System.out.println(test.isFilled()); // expect true
        System.out.println(test2.isFilled()); // expect true

        System.out.println(test);
        System.out.println(test2);

        // test for Circle
        Circle cir = new Circle();
        Circle cir2 = new Circle(1.0);
        Circle cir3 = new Circle(2.0, "black", false);

        double area = cir.getArea();
        double perimeter = cir.getPerimeter();
        double radius = cir.getRadius();
        System.out.println(area);
        System.out.println(perimeter);
        System.out.println(radius);
        System.out.println(cir);

        // test for rectangle
        Rectangle rec = new Rectangle(1.0, 1.0);
        Rectangle rec2 = new Rectangle();
        Rectangle rec3 = new Rectangle(2.0, 2.0, "brown", true);
        System.out.println(rec);

        // test for square
        Square sq = new Square();
        Square sq2 = new Square(1.0);
        Square sq3 = new Square(1.0, "black", true);
        System.out.println(sq);    */


    // tester for the second classes

        Shape2 s1 = new Circle2(5.5, "RED", false);  // Upcast Circle to Shape
        System.out.println(s1);                    // which version?
        // the toString that is overriden in the class Circle
        System.out.println(s1.getArea());          // which version?
        // the method that is overriden in the class Circle
        System.out.println(s1.getPerimeter());     // which version?
        // the method that is overriden in the class Circle
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius())
        // you cannot access the getRadius method since you upcast the object

        Circle2 c1 = (Circle2)s1;                   // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        // Shape2 s2 = new Shape2();
        // this will produce an error since an abstract class cannot be instantiated

        Shape2 s3 = new Rectangle2(1.0, 2.0, "RED", false);   // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength());
        // you cannot access the getLength() method since you upcast the object

        Rectangle2 r1 = (Rectangle2)s3;   // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape2 s4 = new Square2(6.6);     // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide());
        // you cannot access the getSide() method since you upcast the object

// Take note that we downcast Shape s4 to Rectangle,
//  which is a superclass of Square, instead of Square
        Rectangle2 r2 = (Rectangle2)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide());
        // you cannot access the getSide() method since you upcast the object
        System.out.println(r2.getLength());

// Downcast Rectangle r2 to Square
        Square2 sq1 = (Square2)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}
