import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LetterCount {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        int lineCount = 3; // количество считываемых строк
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        int count = 0;

        for (char x : alphabet) {                   // идем по alphabet и  по букве присваеваем в переменню char "x"...
            for (String y : list) {                 // теперь идем по введенному списку и берем оттуда по строке и присваем каждую строчку к "у"
                for (char z : y.toCharArray()) {    // расскладываем строчку на буквенный массив и присваем каждую букву по массиву в переменную "z"
                    if (x == z) {                   // остается теперь сравнить букву с алфавита с буквами из введенной строки
                        count++;
                    }
                }
            }
            System.out.println(x + " " + count);
            count = 0;
        }
    }
}
