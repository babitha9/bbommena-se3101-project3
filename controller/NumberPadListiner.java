package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.BaseBallGame;
import view.GamePannel;

public class NumberPadListiner implements ActionListener {

    GamePannel gamePannel;
    private int keyCount = 0;
    private final int MAXINPUT = 3;
    public NumberPadListiner(GamePannel gamePannel) {
        this.gamePannel = gamePannel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button   = (JButton) e.getSource();
        String keyValue = button.getText();
        ((JButton) e.getSource()).setEnabled(false);

        JTextField gessField = gamePannel.getGameGessField();

        if (keyCount == 0) gessField.setText("");

        BaseBallGame baseBall = gamePannel.getBaseBallGame();
        gessField.setText(gessField.getText().concat(keyValue));
        // baseBall.setGess(keyCount, keyValue.charAt(0) - '0');
        keyCount++;

        String enteredNumber = gessField.getText();

        if (keyCount == MAXINPUT) {

            baseBall.setFullNumber(enteredNumber);
            baseBall.notifyEvent();
            keyCount = 0;
        }
        gamePannel.getCanvas().repaint();
    }

}
