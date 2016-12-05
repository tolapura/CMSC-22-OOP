package lab9_1;

public class Test {

    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 0, 0);     // upcast

        System.out.println(m1);
        m1.moveLeft();
        m1.render();
        System.out.println(m1);

        Movable m2 = new MovableCircle(2, 1, 2, 3, 5); // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
        m2.moveLeft();
        System.out.println(m2);
        m2.moveDown();
        System.out.println(m2);
        m2.moveUp();
        System.out.println(m2);

        Movable m3 = new MovableRectangle(0, 0, 5, 3, 1, 1);
        MovableRectangle m4 = (MovableRectangle) m3;
        m4.moveRight();
        System.out.println();
        m4.render();
        System.out.println(m4);
        m4.moveLeft();
        System.out.println(m2);
        m4.moveDown();
        System.out.println(m4);
    }
}