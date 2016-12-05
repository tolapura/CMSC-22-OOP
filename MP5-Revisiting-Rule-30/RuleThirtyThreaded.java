package RuleThirty;

/** Created by @tolapura
 *  on 12/5/16
 *  **/

public class RuleThirtyThreaded {
    final static int THREAD_COUNT = 10;
    public int[][] array;
    public int size;

    public RuleThirtyThreaded(int size) {
        array = new int[size][size];
        this.size = size;
    }

    public void firstLine() {
        for (int j = 0; j < size; j++) {
            array[0][j] =  (j == size / 2) ? 1 : 0;
            System.out.print(array[0][j]);
        }
        System.out.println();
    }

    public void display() {
        firstLine();
        int portion = (size < THREAD_COUNT) ? size : THREAD_COUNT;
        RuleThirtyParts[] parts = new RuleThirtyParts[portion];
        int each = size / portion;
        int excess = size % portion;

        for (int k = 0; k < size - 1; k++) {
            int start = 0;
            for (int i = 0; i < portion; i++) {
                parts[i] = (i < excess) ? new RuleThirtyParts(array, start, each + 1, k):
                        new RuleThirtyParts(array, start, each, k);
                start = (i < excess) ? start + each + 1 : start + each;
                parts[i].start();
                while(parts[i].isAlive()) {
                    try {
                        parts[i].join();
                    } catch(InterruptedException e) {
                        System.err.println("thread interrupted: " + e.getMessage());
                    }
                }
            }
            for(int i = 0, j = 0; i < parts.length; i++) {
                for (int num: parts[i].curr) {
                    array[k+1][j] = num;
                    System.out.print(num);
                    j++;
                }
            }
            System.out.println();
        }
    }
}
