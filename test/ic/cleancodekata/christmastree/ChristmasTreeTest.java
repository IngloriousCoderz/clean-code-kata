package ic.cleancodekata.christmastree;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChristmasTreeTest {

    @Test
    public void testDefault() {
        Tree tree = new PineTree(7);
        String expected
                = "    /\\\n"
                + "   /  \\\n"
                + "  /    \\\n"
                + " /      \\\n"
                + "/        \\\n"
                + "----------\n"
                + "    ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testMinimalHeight() {
        Tree tree = new PineTree(3);
        String expected
                = "/\\\n"
                + "--\n"
                + "||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testEvenHeight() {
        Tree tree = new PineTree(8);
        String expected
                = "     /\\\n"
                + "    /  \\\n"
                + "   /    \\\n"
                + "  /      \\\n"
                + " /        \\\n"
                + "/          \\\n"
                + "------------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeight() {
        Tree tree = new PineTree(2);
        String result = tree.build();
    }

    @Test
    public void testAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        String expected
                = "    qp\n"
                + "    /\\\n"
                + "   /  \\\n"
                + "  /    \\\n"
                + " /      \\\n"
                + "/        \\\n"
                + "----------\n"
                + "    ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        String expected
                = "    i/\\i\n"
                + "   i/  \\i\n"
                + "  i/    \\i\n"
                + " i/      \\i\n"
                + "i/        \\i\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testCandlesAndAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String expected
                = "     qp\n"
                + "    i/\\i\n"
                + "   i/  \\i\n"
                + "  i/    \\i\n"
                + " i/      \\i\n"
                + "i/        \\i\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testAngelAndCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        String expected
                = "    iqpi\n"
                + "    i/\\i\n"
                + "   i/  \\i\n"
                + "  i/    \\i\n"
                + " i/      \\i\n"
                + "i/        \\i\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testWholeChristmasTree() {
        Tree tree = new PineTree(7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String expected
                = "     qp\n"
                + "    i/\\i\n"
                + "   i/  \\i\n"
                + "  i/ o  \\i\n"
                + " i/   *  \\i\n"
                + "i/   o*** \\i\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        String[] rows = result.split("\n");
        String[] expectedRows = expected.split("\n");
        int length = rows.length;

        assertEquals(expectedRows[0], rows[0]);
        assertEquals(expectedRows[1], rows[1]);
        assertEquals(expectedRows[length - 2], rows[length - 2]);
        assertEquals(expectedRows[length - 1], rows[length - 1]);
    }

    @Test
    public void testWholeChristmasTreeBuiltDifferently() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasBallsDecorator(tree);
        String expected
                = "    iqpi\n"
                + "    i/\\i\n"
                + "   i/  \\i\n"
                + "  i/ o  \\i\n"
                + " i/   *  \\i\n"
                + "i/   o*** \\i\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        String[] rows = result.split("\n");
        String[] expectedRows = expected.split("\n");
        int length = rows.length;

        assertEquals(expectedRows[0], rows[0]);
        assertEquals(expectedRows[1], rows[1]);
        assertEquals(expectedRows[length - 2], rows[length - 2]);
        assertEquals(expectedRows[length - 1], rows[length - 1]);
    }

    @Test
    public void testOakTree() {
        Tree tree = new OakTree(10, 7);
        String expected
                = "/--------\\\n"
                + "|        |\n"
                + "|        |\n"
                + "\\--------/\n"
                + "   \\\\//\n"
                + "    ||\n"
                + "    ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testMinimalHeightOnOak() {
        Tree tree = new OakTree(8, 5);
        String expected
                = "/------\\\n"
                + "\\------/\n"
                + "  \\\\//\n"
                + "   ||\n"
                + "   ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeightOnOak() {
        Tree tree = new OakTree(8, 4);
        String result = tree.build();
    }

    @Test
    public void testChristmasTreeFromOak() {
        Tree tree = new OakTree(10, 7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String expected
                = "     qp\n"
                + "i/--------\\i\n"
                + "i| o   oo |i\n"
                + "i|   *oo  |i\n"
                + "i\\--------/i\n"
                + "    \\\\//\n"
                + "     ||\n"
                + "     ||";

        String result = tree.build();
        String[] rows = result.split("\n");
        String[] expectedRows = expected.split("\n");
        int length = rows.length;

        assertEquals(expectedRows[0], rows[0]);
        assertEquals(expectedRows[1], rows[1]);
        assertEquals(expectedRows[length - 4], rows[length - 4]);
        assertEquals(expectedRows[length - 3], rows[length - 3]);
        assertEquals(expectedRows[length - 2], rows[length - 2]);
        assertEquals(expectedRows[length - 1], rows[length - 1]);
    }
}
