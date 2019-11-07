import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstLetterUpper {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String s1 = s.substring(0, 1).toUpperCase();

        for (int i = 1; i < s.length(); i++) {
            if (" ".equals(s.substring(i - 1, i)))
                s1 += s.substring(i, i + 1).toUpperCase();
            else
                s1 += s.substring(i, i + 1);
        }

        System.out.println(s1);
    }
}
