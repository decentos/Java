import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReflectionClass {

    public static Object createObject() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = reader.readLine();
        Object object = null;

        try {
            Class clazz = Class.forName(className);
            object = clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Class not found");
        }

        return object;
    }

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        System.out.println(createObject().getClass());
    }
}
