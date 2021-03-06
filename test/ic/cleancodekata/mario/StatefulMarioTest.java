package ic.cleancodekata.mario;

import ic.cleancodekata.mario.state.BaseState;
import ic.cleancodekata.mario.state.FireballState;
import ic.cleancodekata.mario.state.FlyingSquirrelState;
import ic.cleancodekata.mario.state.StatefulMario;
import ic.cleancodekata.mario.state.SuperState;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StatefulMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new StatefulMario(new BaseState());

        MarioTestHelper.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new StatefulMario(new SuperState());

        MarioTestHelper.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new StatefulMario(new FireballState());

        MarioTestHelper.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new StatefulMario(new FlyingSquirrelState());

        MarioTestHelper.testFlyingSquirrelMario(mario);
    }
}
