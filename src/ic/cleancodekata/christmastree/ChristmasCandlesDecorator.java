package ic.cleancodekata.christmastree;

import static ic.cleancodekata.christmastree.Tree.SPACE;
import java.util.ArrayList;
import java.util.List;

public class ChristmasCandlesDecorator implements Tree {

    private final static String CANDLE = "ì";

    private final Tree tree;

    public ChristmasCandlesDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public List<String> build() {
        List<String> tree = new ArrayList();
        tree.addAll(buildCanopy());
        tree.addAll(buildBase());
        tree.addAll(buildTrunk());
        return tree;
    }

    @Override
    public List<String> buildCanopy() {
        return putCandles(tree.buildCanopy());
    }

    @Override
    public List<String> buildBase() {
        return shiftRight(tree.buildBase());
    }

    @Override
    public List<String> buildTrunk() {
        return shiftRight(tree.buildTrunk());
    }

    private List<String> putCandles(List<String> rows) {
        List<String> newRows = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            newRows.add(putCandlesOnRow(rows.get(i)));
        }
        return newRows;
    }

    private String putCandlesOnRow(String row) {
        String shiftedRow = shiftRowRight(row);
        String trimmedRow = row.trim();
        int leftIndex = shiftedRow.indexOf(trimmedRow);

        StringBuilder builder = new StringBuilder(shiftedRow);
        builder.setCharAt(leftIndex - 1, CANDLE.charAt(0));
        builder.append(CANDLE);

        return builder.toString();
    }

    private List<String> shiftRight(List<String> rows) {
        List<String> rest = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            rest.add(shiftRowRight(rows.get(i)));
        }
        return rest;
    }

    private String shiftRowRight(String row) {
        return SPACE + row;
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public int getWidth() {
        return tree.getWidth() + 2 * CANDLE.length();
    }

    @Override
    public int getCanopyHeight() {
        return tree.getCanopyHeight();
    }

    @Override
    public int getBaseHeight() {
        return tree.getBaseHeight();
    }

    @Override
    public int getTrunkHeight() {
        return tree.getTrunkHeight();
    }

}
