import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReflectionClass {

    public static Object createObject() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = reader.readLine();

        Class clazz = Class.forName(className);
        Object object = clazz.newInstance();

        return object;
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        System.out.println(createObject().getClass());
    }
}
