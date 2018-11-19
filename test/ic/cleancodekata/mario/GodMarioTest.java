package ic.cleancodekata.mario;

import ic.cleancodekata.mario.god.GodMario;
import ic.cleancodekata.mario.god.Type;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GodMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new GodMario(Type.BASE);

        MarioTest.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new GodMario(Type.SUPER);

        MarioTest.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new GodMario(Type.FIREBALL);

        MarioTest.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new GodMario(Type.FLYING_SQUIRREL);

        MarioTest.testFlyingSquirrelMario(mario);
    }
}
