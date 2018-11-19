/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.cleancodekata.mario.state;

import ic.cleancodekata.mario.KeyCode;

/**
 *
 * @author antony
 */
public class FireballState implements State {

    @Override
    public String onKeyPressed(KeyCode keyCode) {
    switch (keyCode) {
            case DOWN:
                return crash();

            case JUMP:
                return jump();

            case ACTION:
                return shoot();

            default:
                return noop();
        }
    }
    
    private String crash() {
        return "Crashing";
    }

    private String jump() {
        return "Jumping";
    }

    private String shoot() {
        return "Shooting";
    }

    private String noop() {
        return "";
    }
}
