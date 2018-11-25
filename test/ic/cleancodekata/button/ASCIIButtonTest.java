package ic.cleancodekata.button;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ASCIIButtonTest {

    @Test
    public void defaultConfiguration() {
        // given
        ASCIIButton button = new ASCIIButton(10, 10);
        String expected
                = "* * * * * * * * * * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*       ciao      * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "* * * * * * * * * * \n";
        
        // when
        String result = button.build("ciao");
        
        // then
        assertEquals(expected, result);
    }

    @Test
    public void oddRows() {
        // given
        ASCIIButton button = new ASCIIButton(7, 10);
        String expected
                = "* * * * * * * * * * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*       ciao      * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "* * * * * * * * * * \n";
        
        // when
        String result = button.build("ciao");
        
        // then
        assertEquals(expected, result);
    }

    @Test
    public void oddColumns() {
        // given
        ASCIIButton button = new ASCIIButton(10, 7);
        String expected
                = "* * * * * * * \n"
                + "*           * \n"
                + "*           * \n"
                + "*           * \n"
                + "*    ciao   * \n"
                + "*           * \n"
                + "*           * \n"
                + "*           * \n"
                + "*           * \n"
                + "* * * * * * * \n";
        
        // when
        String result = button.build("ciao");
        
        // then
        assertEquals(expected, result);
    }

    @Test
    public void oddPhrase() {
        // given
        ASCIIButton button = new ASCIIButton(10, 10);
        String expected
                = "* * * * * * * * * * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*      hello      * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "*                 * \n"
                + "* * * * * * * * * * \n";
        
        // when
        String result = button.build("hello");
        
        // then
        assertEquals(expected, result);
    }
}
