import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        String s;
        // int x = 1;
        BigDecimal res = BigDecimal.ONE;

        if (n < 0) {
            s = "0";
            return s;
        } else if (n == 0) {
            s = "1";
            return s;
        } else {
            for (int i = 1; i <= n; i++) {
                res = res.multiply(BigDecimal.valueOf(i));
                // x *= i;
            }
            return res.toString();
            // s = "" + x;
            // return s;
        }
    }
}
