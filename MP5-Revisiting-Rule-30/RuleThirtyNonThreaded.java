package RuleThirty;

/** Created by @tolapura
 *  on 12/5/16
 *  **/

public class RuleThirtyNonThreaded {
    public int[][] array;
    public int size;

    RuleThirtyNonThreaded(int size) {
        array = new int[size][size];
        this.size = size;
    }

    private void firstLine() {
        for (int j = 0; j < size; j++){
            array[0][j] = 0;
            }
        array[0][size / 2] = 1;
    }

    private void checkval() {
        for (int i = 1; i < size; i++){
            for (int j = 0; j < size; j++){
                array[i][j] = valueOf(i, j);
            }
        }
    }

    private int valueOf(int i, int j){
        int left = (j == 0)?0: array[i - 1][j - 1];
        int middle = array[i - 1][j];
        int right = (j == size - 1)?0: array[i - 1][j + 1];
        int flag = 1;
        if (left == 1) {
            if (middle == 1)
                flag = 0;
        } else {
            if (middle == 0 && right == 0)
                flag = 0;
        }
        return flag;
    }

    void display() {
        firstLine();
        checkval();
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
