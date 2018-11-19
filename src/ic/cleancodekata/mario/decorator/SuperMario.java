package ic.cleancodekata.mario.decorator;

import ic.cleancodekata.mario.KeyCode;
import ic.cleancodekata.mario.Mario;

public class SuperMario implements Mario {

    private Mario mario;

    public SuperMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String crash() {
        return "Crashing";
    }
}
