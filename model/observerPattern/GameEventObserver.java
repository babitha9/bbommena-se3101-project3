package model.observerPattern;

import view.GamePannel;
import javax.swing.JButton;

public class GameEventObserver implements Observer {

    GamePannel quizPanal;
    private int ballCount = 0;
    private final int MAXINPUT = 3;
    private int struckCount = 0;
    int gessArray[] = new int[3] ;
    public GameEventObserver(GamePannel quizPanal) {
        this.quizPanal = quizPanal;
    }

    @Override
    public void compute(String number) {


        gessArray[0] =   number.charAt(0) -'0';
        gessArray[1] =   number.charAt(1) -'0';
        gessArray[2] =   number.charAt(2) -'0';

        compute(gessArray);

        disableButtons();

        quizPanal.getCanvas().setBall_strikes(ballCount, struckCount);

        if (struckCount == MAXINPUT) {
            GameOver();

        } else {
            enableButtons();
        }
    }



    public void compute(int gessArray[]) {

        struckCount = 0;
        ballCount = 0;
        int keysArray[] = quizPanal.getBaseBallGame().getKeys();

        for (int i = 0; i < 3; i++) {
            if (keysArray[i] == gessArray[i])
                struckCount++;
        }
        calculateBallCount(gessArray, keysArray);

    }

    private void disableButtons() {
        for (JButton jButton : quizPanal.getAlphaButtons()) {
            jButton.setEnabled(false);
        }
    }

    private void enableButtons() {
        for (JButton jButton : quizPanal.getAlphaButtons()) {
            jButton.setEnabled(true);
        }
    }

    private void GameOver() {
        quizPanal.setGameState(GamePannel.GameState.GAMEOVER);
        disableButtons();
    }

    private void calculateBallCount(int gess[], int keys[]) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                if (keys[i] == gess[j])
                    ballCount++;
            }
        }
    }

}
