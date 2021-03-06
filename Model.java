package pacman_java;

import java.awt.event.ActionListener;
import java.swing.Jpanel;
import java.awt.Dimensions;
import java.awt.Font;
import java.awt.ActionEvent;


public class Model extends JPanel implements ActionListener {
    private Dimensions d;
    private final font smallFont = new Font ("Arial", Font.BOLD, 14);
    private boolean inGame = false;
    private boolean dying = false;

    private final int BLOCK_SIZE = 24; 
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 6;
    private int lives, score;
    private int [] dx, dy;
    private int [] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    
    private image heart, ghost;
    private image up, down, left, right;

    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy;

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;
    private int currentSpeed = 3; 
    private short [] screenData = 3;
    private Timer timer;

    private final short levelData[] = {
        19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        21, 0, 0, 0, 17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 18, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 16, 24, 20,
        25, 16, 16, 16, 24, 24, 28, 0, 25, 24, 24, 16, 20, 0, 21,
        1, 17, 16, 20, 0, 0, 0, 0, 0, 0, 0, 17, 20, 0, 21,
        1, 17, 16, 16, 18, 18, 22, 0, 19, 18, 18, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 21,
        1, 25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
        9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 25, 24, 24, 24, 28
    };

    public Model() {
        loadImages();
        initVariables();
        initBoard();
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        }

        private void loadImages() {

            ghost = new ImageIcon("images/ghost.png").getImage();
            pacman1 = new ImageIcon("images/pacman.png").getImage();
            pacman2up = new ImageIcon("images/up1.png").getImage();
            pacman3up = new ImageIcon("images/up2.png").getImage();
            pacman4up = new ImageIcon("images/up3.png").getImage();
            pacman2down = new ImageIcon("images/down1.png").getImage();
            pacman3down = new ImageIcon("images/down2.png").getImage();
            pacman4down = new ImageIcon("images/down3.png").getImage();
            pacman2left = new ImageIcon("images/left1.png").getImage();
            pacman3left = new ImageIcon("images/left2.png").getImage();
            pacman4left = new ImageIcon("images/left3.png").getImage();
            pacman2right = new ImageIcon("images/right1.png").getImage();
            pacman3right = new ImageIcon("images/right2.png").getImage();
            pacman4right = new ImageIcon("images/right3.png").getImage();
    
        }
        private void initVariables() {

            screenData = new short[N_BLOCKS * N_BLOCKS];
            mazeColor = new Color(5, 100, 5);
            d = new Dimension(400, 400);
            ghost_x = new int[MAX_GHOSTS];
            ghost_dx = new int[MAX_GHOSTS];
            ghost_y = new int[MAX_GHOSTS];
            ghost_dy = new int[MAX_GHOSTS];
            ghostSpeed = new int[MAX_GHOSTS];
            dx = new int[4];
            dy = new int[4];
            
            timer = new Timer(40, this);
            timer.start();
        }
        

    
    }

