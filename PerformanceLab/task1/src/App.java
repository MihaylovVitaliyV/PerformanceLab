import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        int i = 0; // position in array
        int pc = 1; // path count

        int path[] = { 1 };
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = reader.nextInt();

        System.out.println("Enter m: ");

        int m = reader.nextInt();

        if (n < m) {
            m = m % n;
        }

        if (m != 0) {
            m--;
        } else {
            m = n - 1;
        }

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        reader.close();

        boolean isEndCycle = false;

        do {
            i += m;

            if (i > n - 1) {
                i -= n;
            }

            if (arr[i] == arr[0]) {
                isEndCycle = true;
            } else {
                path = addX(pc, path, arr[i]);
                pc++;
            }

        } while (isEndCycle == false);

        System.out.println(Arrays.toString(path));
    }

    // Function to add x in arr
    public static int[] addX(int n, int arr[], int x) {
        int i;

        int newarr[] = new int[n + 1];

        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;
        return newarr;
    }
}
