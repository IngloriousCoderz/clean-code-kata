package ic.cleancodekata.mario;

import ic.cleancodekata.mario.decorator.BaseMario;
import ic.cleancodekata.mario.decorator.FireballMario;
import ic.cleancodekata.mario.decorator.FlyingSquirrelMario;
import ic.cleancodekata.mario.decorator.SuperMario;
import org.junit.Test;

public class DecoratorMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new BaseMario();

        MarioTestHelper.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);

        MarioTestHelper.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);
        mario = new FireballMario(mario);

        MarioTestHelper.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new BaseMario();
        mario = new SuperMario(mario);
        mario = new FlyingSquirrelMario(mario);

        MarioTestHelper.testFlyingSquirrelMario(mario);
    }
}
