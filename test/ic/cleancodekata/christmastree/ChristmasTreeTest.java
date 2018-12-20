package ic.cleancodekata.christmastree;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChristmasTreeTest {

    @Test
    public void testDefault() {
        Tree tree = new PineTree(7);
        String[] expected = new String[]{
            "    /\\",
            "   /  \\",
            "  /    \\",
            " /      \\",
            "/        \\",
            "----------",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testMinimalHeight() {
        Tree tree = new PineTree(3);
        String[] expected = new String[]{
            "/\\",
            "--",
            "||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testEvenHeight() {
        Tree tree = new PineTree(8);
        String[] expected = new String[]{
            "     /\\",
            "    /  \\",
            "   /    \\",
            "  /      \\",
            " /        \\",
            "/          \\",
            "------------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeight() {
        Tree tree = new PineTree(2);
        tree.build();
    }

    @Test
    public void testAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "    qp",
            "    /\\",
            "   /  \\",
            "  /    \\",
            " /      \\",
            "/        \\",
            "----------",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        String[] expected = new String[]{
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testCandlesAndAngel() {
        Tree tree = new PineTree(7);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testAngelAndCandles() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        String[] expected = new String[]{
            "    ìqpì",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/    \\ì",
            " ì/      \\ì",
            "ì/        \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testWholeChristmasTree() {
        Tree tree = new PineTree(7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/ o  \\ì",
            " ì/   *  \\ì",
            "ì/   o*** \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        int length = expected.length;

        assertEquals(expected[0], result.get(0));
        assertEquals(expected[1], result.get(1));
        assertEquals(expected[length - 2], result.get(length - 2));
        assertEquals(expected[length - 1], result.get(length - 1));
    }

    @Test
    public void testWholeChristmasTreeBuiltDifferently() {
        Tree tree = new PineTree(7);
        tree = new ChristmasAngelDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasBallsDecorator(tree);
        String[] expected = new String[]{
            "    ìqpì",
            "    ì/\\ì",
            "   ì/  \\ì",
            "  ì/ o  \\ì",
            " ì/   *  \\ì",
            "ì/   o*** \\ì",
            " ----------",
            "     ||"
        };

        List<String> result = tree.build();
        int length = expected.length;

        assertEquals(expected[0], result.get(0));
        assertEquals(expected[1], result.get(1));
        assertEquals(expected[length - 2], result.get(length - 2));
        assertEquals(expected[length - 1], result.get(length - 1));
    }

    @Test
    public void testOakTree() {
        Tree tree = new OakTree(10, 7);
        String[] expected = new String[]{
            "/--------\\",
            "|        |",
            "|        |",
            "\\--------/",
            "   \\\\//",
            "    ||",
            "    ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testMinimalHeightOnOak() {
        Tree tree = new OakTree(8, 5);
        String[] expected = new String[]{
            "/------\\",
            "\\------/",
            "  \\\\//",
            "   ||",
            "   ||"
        };

        List<String> result = tree.build();
        assertArrayEquals(expected, result.toArray());
    }

    @Test(expected = HeightTooSmallException.class)
    public void testImpossibleHeightOnOak() {
        Tree tree = new OakTree(8, 4);
        tree.build();
    }

    @Test
    public void testChristmasTreeFromOak() {
        Tree tree = new OakTree(10, 7);
        tree = new ChristmasBallsDecorator(tree);
        tree = new ChristmasCandlesDecorator(tree);
        tree = new ChristmasAngelDecorator(tree);
        String[] expected = new String[]{
            "     qp",
            "ì/--------\\ì",
            "ì| o   oo |ì",
            "ì|   *oo  |ì",
            "ì\\--------/ì",
            "    \\\\//",
            "     ||",
            "     ||"
        };

        System.out.println(String.join("\n", expected));
        
        List<String> result = tree.build();
        int length = expected.length;

        assertEquals(expected[0], result.get(0));
        assertEquals(expected[1], result.get(1));
        assertEquals(expected[length - 4], result.get(length - 4));
        assertEquals(expected[length - 3], result.get(length - 3));
        assertEquals(expected[length - 2], result.get(length - 2));
        assertEquals(expected[length - 1], result.get(length - 1));
    }
}
