package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;

import controller.PlayButtonListiner;
import controller.NumberPadListiner;
import controller.ExitButtonListiner;
import model.BaseBallGame;
import model.observerPattern.GameEventObserver;

import java.awt.Font;
import java.awt.Color;

public class GamePannel {

public enum GameState{
PLAYING,READY,GAMEOVER
}

  private JFrame window;
  private Canvas canvas;
  private GameState gameState = GameState.READY;
 
private BaseBallGame baseBallGame = new BaseBallGame();

  ArrayList<JButton> alphaButtons = new ArrayList<JButton>();
  JTextField KeyText  = new JTextField() ;
  JTextField GessText = new JTextField();


  public GamePannel(JFrame window) {
    this.window = window;
    window.setTitle("Base Ball Game");

  }

  public void init() {
    Container container = window.getContentPane();
    container.setPreferredSize(new Dimension(500, 500));
    canvas = new Canvas(this);
    container.add(canvas, BorderLayout.CENTER);



    JPanel northPanel = new JPanel();

    container.add(northPanel, BorderLayout.NORTH);
    northPanel.setLayout(new GridLayout(2, 2));
    northPanel.setBackground(Color.white);
    KeyText.setEditable(false);
    GessText.setEditable(false);
    Font font = new Font("Courier", Font.BOLD, 12);
    KeyText.setForeground(Color.RED);
    KeyText.setFont(font);
    GessText.setFont(font);

    addNorthPannel(northPanel);
    
    JPanel southPanal = new JPanel();

    container.add(southPanal, BorderLayout.SOUTH);
    southPanal.setLayout(new GridLayout(4, 7));
    southPanal.setBackground(Color.BLACK);

    NumberPadListiner nummberPad = new NumberPadListiner(this);

    createNumberPad(nummberPad,alphaButtons,southPanal);

    JButton play = new JButton("Play");
    JButton exit = new JButton("exit"); 
    play.setForeground(Color.green);
    exit.setForeground(Color.red);
    southPanal.add(play);
    southPanal.add(exit);
    play.addActionListener(new PlayButtonListiner(this));
    exit.addActionListener(new ExitButtonListiner(this));

   
    for (JButton jButton : alphaButtons) {
      jButton.setEnabled(false);
    }

    GameEventObserver Observer = new GameEventObserver(this);
    baseBallGame.addLisiner(Observer);
  }

  
  private void createNumberPad(NumberPadListiner nummberPad, ArrayList<JButton> alphaButtons ,JPanel southPanal ){
    for (int i = 0; i < 10; i++) {
      alphaButtons.add(new JButton(""+i));
      southPanal.add(alphaButtons.get(i));
      alphaButtons.get(i).addActionListener(nummberPad);
    }
  }

  private void addNorthPannel(JPanel northPanel){
    northPanel.add(new JLabel("Secret Key"));
    northPanel.add(KeyText);
    northPanel.add(new JLabel("Game Key"));
    northPanel.add(GessText);
  }
 
  public Canvas getCanvas() {
    return this.canvas;
  }

  public JFrame getWindow() {
    return this.window;
  }

  public JTextField getGameKeyField() {
    return KeyText;
  }

  public JTextField getGameGessField() {
    return GessText;
  }

 
  public void setBaseBallGame(BaseBallGame baseBallGame) {
    this.baseBallGame = baseBallGame;
  
}

public BaseBallGame getBaseBallGame() {
    return baseBallGame;
}

  public ArrayList<JButton> getAlphaButtons() {
      return alphaButtons;
  }


  public GameState getGameState() {
      return gameState;
  }

  public void setGameState(GameState gameState) {
      this.gameState = gameState;
  }

 

}
