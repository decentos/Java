package ObservableImpl;

import java.util.Observable;
import java.util.Observer;

class Girl extends Observable{
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers(this.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.setChanged();
        this.notifyObservers(this.age);
    }
}

class Romeo implements Observer{
    @Override
    public void update(Observable target, Object obj){
        Girl girl = (Girl)target;
        String newName;
        int newAge;
        if( obj instanceof String ){
            newName = girl.getName();
            System.out.println("Girl's name changed to " + newName);
        }else{
            newAge = girl.getAge();
            System.out.println("Girl's age changed to " + newAge);
        }
    }
}

public class ObservableImpl {
    public static void main(String[] args) {
        Romeo romeo = new Romeo();
        Girl girl = new Girl("Juliette", 14);
        girl.addObserver(romeo);
        girl.setAge(39);
        girl.setName("Angel");
    }
}
