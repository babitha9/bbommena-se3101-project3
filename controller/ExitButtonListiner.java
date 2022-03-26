package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GamePannel;

public class ExitButtonListiner implements ActionListener {

  GamePannel quizPanal;

  public ExitButtonListiner(GamePannel quizPanal) {
    this.quizPanal = quizPanal;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
System.exit(0);
  }

}
