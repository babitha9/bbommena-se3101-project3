package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GamePannel;
import view.Canvas;
import javax.swing.JTextField;

import model.BaseBallGame;
import model.observerPattern.GameEventObserver;

import javax.swing.JButton;

public class PlayButtonListiner implements ActionListener {

  GamePannel quizPanal;

  public PlayButtonListiner(GamePannel quizPanal) {
    this.quizPanal = quizPanal;
  }

  @Override
  public void actionPerformed(ActionEvent e) {


      BaseBallGame baseBallGame = new BaseBallGame();
      quizPanal.setBaseBallGame(baseBallGame);
      quizPanal.setGameState(GamePannel.GameState.PLAYING);
      GameEventObserver Observer = new GameEventObserver(quizPanal);
      baseBallGame.addLisiner(Observer);
      int[] keys =  baseBallGame.getKeys();

      String textKeys  = ""+keys[0]+ keys[1]+keys[2];

      JTextField textKeyField = quizPanal.getGameKeyField();
      JTextField textFieldGess = quizPanal.getGameGessField();

      textKeyField.setText(textKeys);
      textFieldGess.setText("");
      Canvas.helth = 5;
      for (JButton jButton : quizPanal.getAlphaButtons()) {
        jButton.setEnabled(true);
      }
      quizPanal.getCanvas().setBall_strikes(0, 0);
      quizPanal.getCanvas().repaint();
    
  }

}
