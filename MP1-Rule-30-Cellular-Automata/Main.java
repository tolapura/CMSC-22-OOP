import java.util.Scanner;

public class Rule {

    public static int[][] firstLine(int[][]grid, int x) {
        int j;
        for (j = 0; j < x; j++){
            grid[0][j] = 0;
        }
        grid[0][x / 2] = 1;
        return grid;
    }

    public static int ValueOf(int[][]grid, int x, int i, int j){
        int left = (j == 0)?0:grid[i - 1][j - 1];
        int middle = grid[i - 1][j];
        int right = (j == x - 1)?0:grid[i - 1][j + 1];
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

    public static int[][] checkval(int[][]grid, int x){
        int i, j;
        for (i = 1; i < x; i++){
            for (j = 0; j < x; j++){
                grid[i][j] = ValueOf(grid, x, i, j);
            }
        }
        return grid;
    }

    public static void print(int[][]grid, int x){
        int i, j;
        for(i = 0; i < x; i++){
            for (j = 0; j < x; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int x;
        Scanner inputs = new Scanner(System.in);
        do {
            System.out.println("Enter an integer between 1 to 30");
            x = inputs.nextInt();
        } while (x < 1 || x > 30);
        int[][] grid = new int[x][x];
        firstLine(grid, x);
        checkval(grid, x);
        print(grid, x);
    }
}
