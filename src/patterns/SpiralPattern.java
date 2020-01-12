package patterns;

import java.util.Scanner;

public class SpiralPattern {

    private int[][] input;

    public static void main(String[] args) {

        SpiralPattern pattern = new SpiralPattern();

        pattern.createAndPopulateArray();
        pattern.normalPrint();
        pattern.spiralPrint();
    }

    private void createAndPopulateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array dimensions: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        input = new int[x][y];

        populateArray(x, y);
    }

    public void populateArray(int x, int y) {
        int data = 1;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                input[i][j] = data++;
            }
        }
    }

    public void normalPrint() {
        for (int[] row : input) {
            for (int cell : row) {
                System.out.print(cell + "  ");
            }
            System.out.println();
        }
    }

    public void spiralPrint() {
        int x = input[0].length;
        int y = input.length;
        int size = x * y;
        int i = 0, j = 0;
        int ll = 0, tl = 0, rl = x, bl = y;

        while (size > 0) {

            while (j < rl) {
                System.out.print(input[i][j++] + " ");
                size -= 1;
            } j--; rl--;
            while (i+1 < bl && size > 0) {
                System.out.print(input[++i][j] + " ");
                size -= 1;
            } bl--;
            while (j-1 >= ll && size > 0) {
                System.out.print(input[i][--j] + " ");
                size -= 1;
            } ll++;
            while (i-1 > tl && size > 0) {
                System.out.print(input[--i][j] + " ");
                size -= 1;
            } tl++;

//            tl++;
//            rl--;
//            bl--;
//            ll++;

            i = tl;
            j = ll;
        }
    }

}
