import java.lang.reflect.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] arr = { 12, 3, 18, 24, 0, 5, -2 };
        System.out.println(sort(arr));

    }

    public static int[] sort(int[] arrA) {
        if (arrA == null) {
            return null;
        }
        if (arrA.length < 2) {
            return arrA;
        }
        int[] arrB = new int[arrA.length / 2];
        System.arraycopy(arrA, 0, arrB, 0, arrA.length / 2);
        int[] arrC = new int[arrA.length / 2];
        System.arraycopy(arrA, arrA.length / 2, arrC, 0, arrC.length);
        arrB = sort(arrB);
        arrC = sort(arrC);
        return merge(arrB, arrC);
    }

    public static int[] merge(int[] arrA, int[] arrB) {
        int[] arrC = new int[arrA.length + arrB.length];
        int posA = 0, posB = 0;
        for (int i = 0; i < arrC.length; i++) {
            if (posA == arrA.length) {
                arrC[i] = arrB[i - posB];
            } else {
                if (posB == arrB.length){
                    arrC[i] = arrA[i - posA];
                }else{
                    if (arrA[i-posA]<arrB[i-posB]){
                        arrC[i] = arrA[i-posA];
                        posB++;
                    }else{
                        if (arrB[i - posB] < arrA[i - posA]){
                            arrC[i] = arrB[i - posB];
                            posA++;
                        }

                    }
                }
            }
        }
        return arrC;
    }
}
