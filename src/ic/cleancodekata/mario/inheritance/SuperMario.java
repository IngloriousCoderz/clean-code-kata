package ic.cleancodekata.mario.inheritance;

import ic.cleancodekata.mario.KeyCode;

public class SuperMario extends BaseMario {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
        switch (keyCode) {
            case DOWN:
                return crash();

            default:
                return super.onKeyPressed(keyCode);
        }
    }

    private String crash() {
        return "Crashing";
    }
}
