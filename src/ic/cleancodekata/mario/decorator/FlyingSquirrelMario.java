package ic.cleancodekata.mario.decorator;

import ic.cleancodekata.mario.KeyCode;
import ic.cleancodekata.mario.Mario;

public class FlyingSquirrelMario implements Mario {

    private Mario mario;

    public FlyingSquirrelMario(Mario mario) {
        this.mario = mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case JUMP:
                return glide();

            default:
                return mario.onKeyPressed(keyCode);
        }
    }

    private String glide() {
        return "Gliding";
    }
}
