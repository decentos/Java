public class TableX {
    public static void main(String[] args) {
        int a = 1;

        while(a <= 10) {
            System.out.print(a + "\t");

            int b = 2;
            while(b <= 10) {
                int x = a * b;
                System.out.print(x + "\t");
                b++;
            }
            System.out.println();
            a++;
        }
    }
}
