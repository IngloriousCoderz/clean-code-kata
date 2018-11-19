package ic.cleancodekata.mario.state;

import ic.cleancodekata.mario.KeyCode;

public interface State {

    public String onKeyPressed(KeyCode keyCode);
}
