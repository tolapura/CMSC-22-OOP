package RuleThirty;

/** Created by @tolapura
 *  on 12/5/16
 *  **/

public class Main {
    public static final int SIZE = 30;

    public static void main(String[] args) {
        /** THIS IS FOR THREADING **/
        long threadStart, threadEnd, timeThreaded;
        threadStart = System.currentTimeMillis();
        RuleThirtyThreaded test1 = new RuleThirtyThreaded(SIZE);
        test1.display();
        threadEnd = System.currentTimeMillis();
        timeThreaded = threadEnd - threadStart;
        System.out.println("THREADED: " + timeThreaded);

        /** THIS IS FOR NON - THREADING **/
        long nonthreadStart, nonthreadEnd, timeNonThreaded;
        nonthreadStart = System.currentTimeMillis();
        RuleThirtyNonThreaded test2 = new RuleThirtyNonThreaded(SIZE);
        test2.display();
        nonthreadEnd = System.currentTimeMillis();
        timeNonThreaded = nonthreadEnd - nonthreadStart;
        System.out.println("NON-THREADED: " + timeNonThreaded);
    }
}
