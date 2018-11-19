package ic.cleancodekata.mario.inheritance;

import ic.cleancodekata.mario.KeyCode;

public class FireballMario extends SuperMario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case ACTION:
                return shoot();

            default:
                return super.onKeyPressed(keyCode);
        }
    }

    private String shoot() {
        return "Shooting";
    }
}
