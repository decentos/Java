import java.util.*;

public class GameProcess {

    private GameHelper helper = new GameHelper();
    private ArrayList<GameLogic> gameLogicList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        GameLogic one = new GameLogic();
        one.setName("google.com");
        GameLogic two = new GameLogic();
        two.setName("instagram.com");
        GameLogic three = new GameLogic();
        three.setName("fb.com");

        gameLogicList.add(one);
        gameLogicList.add(two);
        gameLogicList.add(three);

        System.out.println("Ваша цель - потопить три \"сайта\".");
        System.out.println("google.com, instagram.com, fb.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов!");

        for (GameLogic gameLogicToSet : gameLogicList) {
            ArrayList<String> newLocation = helper.placeGameLogic(3);

            gameLogicToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!gameLogicList.isEmpty()) {

            String userGuess = helper.getUserInput("Сделайте выстрел");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (GameLogic gameLogicToTest : gameLogicList) {
            result = gameLogicToTest.checkYourself(userGuess);

            if (result.equals("Попал")) {
                break;
            }

            if (result.equals("Потопил")) {
                gameLogicList.remove(gameLogicToTest);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все сайты ушли ко дну! Вас больше не попросят настроить таргет!");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток;");
            System.out.println("Вам реально нужно менять вид деятельности!");
        }
        else {
            System.out.println("Это заняло у вас довольно много времени и " + numOfGuesses + " попыток.");
            System.out.println("Видимо, клиенты вас не сильно раздражают :)");
        }
    }

    public static void main(String[] args) {
        GameProcess game = new GameProcess();
        game.setUpGame();
        game.startPlaying();
    }

}
