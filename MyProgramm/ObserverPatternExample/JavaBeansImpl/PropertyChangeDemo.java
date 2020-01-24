package JavaBeansImpl;

import java.io.Serializable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

class GuineaPig implements Serializable{
    private String name;
    private int age;
    private final Set<PropertyChangeListener> listeners = new HashSet<>();

    public GuineaPig(){}

    public GuineaPig(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        PropertyChangeEvent evt =
                new PropertyChangeEvent(this, "name", this.name, name);
        this.name = name;
        this.listeners.forEach(lis -> lis.propertyChange(evt));
    }

    public void setAge(int age) {
        PropertyChangeEvent evt =
                new PropertyChangeEvent(this, "age", this.age, age);
        this.age = age;
        this.listeners.forEach(lis -> lis.propertyChange(evt));
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.listeners.add(listener);
    }
}

class PigListener implements PropertyChangeListener{
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        String oldName, newName;
        int oldAge, newAge;
        switch( evt.getPropertyName() ){
            case "name" :
                oldName = (String)evt.getOldValue();
                newName = (String)evt.getNewValue();
                System.out.println(oldName + " changed to " + newName);
                break;
            case "age" :
                oldAge = (int)evt.getOldValue();
                newAge = (int)evt.getNewValue();
                System.out.println(oldAge + " changed to " + newAge);
                break;
        }
    }
}

public class PropertyChangeDemo {
    public static void main(String[] args) {
        GuineaPig gp = new GuineaPig("Sam", 1);
        PigListener pl = new PigListener();
        gp.addPropertyChangeListener(pl);
        gp.setName("Greg");
        gp.setAge(29);
    }
}
