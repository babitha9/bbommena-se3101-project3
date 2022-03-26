package view;

import javax.swing.JPanel;

import view.GamePannel.GameState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Canvas extends JPanel {

    GamePannel quizPanal;
    public static int width = 500;
    public static int height = 500;
    public static int helth = 5;

private int balls;
private int strikes;

    public Canvas(GamePannel quizPanal) {
        this.quizPanal = quizPanal;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics gs) {
        super.paintComponent(gs);
        Graphics2D graphics2D = (Graphics2D) gs;
        
GameState gameState =  quizPanal.getGameState();

if(gameState.equals(GameState.READY)){

    gameStart(graphics2D);
   
}else{
   
    setYellow(graphics2D);

    if(gameState.equals(GameState.GAMEOVER)){
        gameOver(graphics2D);
    }
    setYellow(graphics2D);
    graphics2D.drawString("Balls "+balls, 20, 120);

    for (int i = 0; i < 3; i++) {
        if(i<balls){
            graphics2D.fillOval(i*150+115, 90, 50, 50);
        }else{
            graphics2D.drawOval(i*150+115, 90, 50, 50);

        }
    }

    graphics2D.drawString("strikes "+strikes, 20, 220);


    for (int i = 0; i < 3; i++) {
        if(i<strikes){
            graphics2D.fillOval(i*150+115, 190, 50, 50);
        }else{
            graphics2D.drawOval(i*150+115, 190, 50, 50);

        }
    }
}
}

public void setBall_strikes(int balls,int strikes){
this.balls = balls;
this.strikes = strikes;
}

private void setYellow(Graphics2D graphics2D){
    graphics2D.setFont(new Font("Courier New", Font.BOLD, 15));
    graphics2D.setColor(Color.yellow);
}

private void gameStart( Graphics2D graphics2D){
    graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
    graphics2D.setColor(Color.BLUE);
    graphics2D.drawString("Click on < Play > to Start", 30, 130);
}

private void gameOver( Graphics2D graphics2D){
   graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
    graphics2D.setColor(Color.RED);
    graphics2D.drawString("GAME OVER", 160, 170);
}

}
