package ic.cleancodekata.mario;

import ic.cleancodekata.mario.inheritance.BaseMario;
import ic.cleancodekata.mario.inheritance.FireballMario;
import ic.cleancodekata.mario.inheritance.FlyingSquirrelMario;
import ic.cleancodekata.mario.inheritance.SuperMario;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InheritanceMarioTest {

    @Test
    public void testBaseMario() {
        Mario mario = new BaseMario();
        
        MarioTest.testBaseMario(mario);
    }

    @Test
    public void testSuperMario() {
        Mario mario = new SuperMario();
        
        MarioTest.testSuperMario(mario);
    }

    @Test
    public void testFireballMario() {
        Mario mario = new FireballMario();
        
        MarioTest.testFireballMario(mario);
    }

    @Test
    public void testFlyingSquirrelMario() {
        Mario mario = new FlyingSquirrelMario();
        
        MarioTest.testFlyingSquirrelMario(mario);
    }
}
