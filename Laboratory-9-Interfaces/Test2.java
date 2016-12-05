package lab9_2;

public class Test2 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        System.out.printf("%.02f\n", c1.getPerimeter());
        System.out.printf("%.02f\n", c1.getArea());
        System.out.println(c1);

        Circle c2 = new Circle(7);
        System.out.printf("%.02f\n",c2.getPerimeter());
        System.out.printf("%.02f\n",c2.getArea());
        System.out.println(c2);

        GeometricObject rc1 = new ResizableCircle(5);
        Resizable rc1_1 = (Resizable)rc1;
        System.out.printf("%.02f\n",rc1.getPerimeter());
        System.out.printf("%.02f\n",rc1.getArea());
        rc1_1.resize(-50);
        System.out.println(rc1);

        GeometricObject rc2 = new ResizableCircle(5);
        Resizable rc2_1 = (Resizable)rc2;
        System.out.printf("%.02f\n",rc2.getPerimeter());
        System.out.printf("%.02f\n",rc2.getArea());
        rc2_1.resize(100);
        System.out.println(rc2);
    }
}
