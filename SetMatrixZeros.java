public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean[] haszero = new boolean[matrix.length + matrix[0].length];
        for (int i = 0; i < haszero.length; i++)
            haszero[i] = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    haszero[i] = true;
                    haszero[j + matrix.length] = true;
                }
            }
        }

//        for (int i = 0; i < haszero.length; i++)
//            System.out.print(haszero[i] + "\t");
//        System.out.println();
        for (int i = 0; i < haszero.length; i++) {
            if (haszero[i] == true) {
                if (i < matrix.length)
                    for (int j = 0; j < matrix[0].length; j++)
                        matrix[i][j] = 0;
                else
                    for (int j = 0; j < matrix.length; j++)
                        matrix[j][i - matrix.length] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        SetMatrixZeros smz = new SetMatrixZeros();
        smz.setZeroes(arr);
        for (int i[] : arr) {
            System.out.print("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        }
    }
}
