package ic.cleancodekata.mario.decorator;

import ic.cleancodekata.mario.KeyCode;
import ic.cleancodekata.mario.Mario;

public class FireballMario implements Mario {

    private Mario mario;

    public FireballMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case ACTION:
                return shoot();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String shoot() {
        return "Shooting";
    }
}
