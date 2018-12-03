package ic.cleancodekata.christmastree;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChristmasTreeTest {

    @Test
    public void testDefault() {
        Tree tree = new FirTree(7);
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
        Tree tree = new FirTree(3);
        String expected
                = "/\\\n"
                + "--\n"
                + "||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testEvenHeight() {
        Tree tree = new FirTree(8);
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
        Tree tree = new FirTree(2);
        String expected = "||\n";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testAngel() {
        Tree tree = new FirTree(7);
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
        Tree tree = new FirTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        String expected
                = "    |/\\|\n"
                + "   |/  \\|\n"
                + "  |/    \\|\n"
                + " |/      \\|\n"
                + "|/        \\|\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testCandlesAndAngel() {
        Tree tree = new FirTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String expected
                = "     qp\n"
                + "    |/\\|\n"
                + "   |/  \\|\n"
                + "  |/    \\|\n"
                + " |/      \\|\n"
                + "|/        \\|\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testAngelAndCandles() {
        Tree tree = new FirTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        String expected
                = "     qp\n"
                + "    |/\\|\n"
                + "   |/  \\|\n"
                + "  |/    \\|\n"
                + " |/      \\|\n"
                + "|/        \\|\n"
                + " ----------\n"
                + "     ||";

        String result = tree.build();
        assertEquals(expected, result);
    }

    @Test
    public void testWholeChristmasTree() {
        Tree tree = new FirTree(7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);

        String result = tree.build();
        String[] levels = result.split("\n");
        int length = levels.length;
        assertEquals("     qp", levels[0]);
        assertEquals("    |/\\|", levels[1]);
        assertEquals(" ----------", levels[length - 2]);
        assertEquals("     ||", levels[length - 1]);

//        System.out.println(result);
    }

    @Test
    public void testWholeChristmasTreeBuiltDifferently() {
        Tree tree = new FirTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasBallsDecorator(tree);

        String result = tree.build();
        String[] levels = result.split("\n");
        int length = levels.length;
        assertEquals("     qp", levels[0]);
        assertEquals("    |/\\|", levels[1]);
        assertEquals(" ----------", levels[length - 2]);
        assertEquals("     ||", levels[length - 1]);

//        System.out.println(result);
    }
}
