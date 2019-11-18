import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameSnake extends JFrame {

    final String TITLE_OF_PROGRAMM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final int CELL_SIZE = 20;
    final int CANVAS_WIDTH = 30;
    final int CANVAS_HEIGHT = 20;
    final int START_SNAKE_SIZE = 5;
    final int START_SNAKE_X = CANVAS_WIDTH/2;
    final int START_SNAKE_Y = CANVAS_HEIGHT/2;
    final Color SNAKE_COLOR = Color.darkGray;
    final Color FOOD_COLOR = Color.green;
    final Color POISON_COLOR = Color.red;
    static final int KEY_LEFT = 37;
    static final int KEY_UP = 38;
    static final int KEY_RIGHT = 39;
    static final int KEY_DOWN = 40;
    final int SNAKE_DELAY = 150;
    boolean gameOver = false;

    Canvas canvas;
    Snake snake;
    Food food;
    // Poison poison; // TODO: create Poison


    public static void main(String[] args) {
        new GameSnake().game();
    }

    public GameSnake() {
        setTitle(TITLE_OF_PROGRAMM + " : " + START_SNAKE_SIZE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.setPreferredSize(new Dimension(
                CELL_SIZE * CANVAS_WIDTH - 10,
                CELL_SIZE * CANVAS_HEIGHT - 10));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void game() {
        snake = new Snake(
                START_SNAKE_X,
                START_SNAKE_Y,
                START_SNAKE_SIZE,
                KEY_RIGHT, this);

        food = new Food(this);
        //poison = new Poison(this);

        while (!gameOver) {
            snake.move();
            if(food.isEaten()) {
                food.appear();
                //poison.add();
            }
            canvas.repaint();
            sleep(SNAKE_DELAY);
        }
        JOptionPane.showMessageDialog(GameSnake.this, GAME_OVER_MSG);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isCoordinatesBusy(int x, int y) {
        return snake.isInSnake(x, y); // || snake.isPoison(x, y);
    }

    class Canvas extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            //poison.paint(g2D);
        }
    }
}
