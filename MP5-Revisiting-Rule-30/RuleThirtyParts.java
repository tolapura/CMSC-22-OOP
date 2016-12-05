package RuleThirty;

/** Created by @tolapura
 *  on 12/5/16
 *  **/

public class RuleThirtyParts extends Thread {
    public int end;
    public int start;
    public int[] prev;
    public int[] curr;
    public int generation;

    RuleThirtyParts(int[][] array, int start, int end, int generation) {
        prev = new int[array.length];
        for (int i = 0; i < array.length; i++){
            prev[i] = array[generation][i];
        }
        this.start = start;
        this.end = end;
        this.generation = generation;
        this.curr = new int[end];
    }

    private void checkval() {
        for (int i = 0; i < end; i++){
                curr[i]= valueOf(i+start);
            }
        }

    private int valueOf(int i){
        int left = (i == 0) ? 0 : prev[i-1];
        int middle = prev[i];
        int right = (i == prev.length - 1)? 0 : prev[i+1];
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

    public void run() {
        checkval();
    }
}
