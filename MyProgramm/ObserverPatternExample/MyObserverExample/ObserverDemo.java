package MyObserverExample;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Spammable{
    void suffer();
}

class Victim implements Spammable{
    @Override
    public void suffer(){
        System.out.println("I was spammed...");
    }
}

class Spammer{
    List<Spammable> victims = new ArrayList<>();
    void sendSpam(){
        victims.forEach(Spammable::suffer);
    }
    void addVictim(Spammable victim){
        victims.add(victim);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Spammer spammer = new Spammer();
        Victim victim = new Victim();
        spammer.addVictim(victim);
        spammer.sendSpam();
    }
}
