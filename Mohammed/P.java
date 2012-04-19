package Mohammed;

/**
 *
 * @author Mohammed
 */
public class P {

    public static void p(String s) {
        System.out.println(s);
    }

    public static void p(int[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            int[] colArr = arr[r];
            for (int c = 0; c < colArr.length; c++) {
                System.out.print(" " + arr[r][c]);
            }
            System.out.println();
        }
    }
}
