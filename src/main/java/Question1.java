import java.io.IOException;

public class Question1 {
    public static void main(String args[]) throws IOException {

        int[] intArray = new int[]{8, 12, 16, 20, 24};

        System.out.println("The highest common factor is: "+findGCD(intArray));
    }
    static int findGCD(int arr[]) {

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcdNumbr(arr[i], result);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    static int gcdNumbr(int val_1, int val_2) {
        if (val_1 == 0)
            return val_2;
        return gcdNumbr(val_2 % val_1, val_1);
    }
}
