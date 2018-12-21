package ic.cleancodekata.christmastree;

import static ic.cleancodekata.christmastree.Tree.SPACE;
import java.util.ArrayList;
import java.util.List;

public class ChristmasCandlesDecorator extends AbstractTree {

    private final static String CANDLE = "ì";

    private final Tree tree;

    public ChristmasCandlesDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public List<String> buildCanopy() {
        return putCandles(tree.buildCanopy());
    }

    @Override
    public String buildBaseRow() {
        return shiftRowRight(tree.buildBaseRow());
    }

    @Override
    public String buildTrunkRow() {
        return shiftRowRight(tree.buildTrunkRow());
    }

    private List<String> putCandles(List<String> rows) {
        List<String> newRows = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            newRows.add(putCandlesOnRow(rows.get(i)));
        }
        return newRows;
    }

    private String putCandlesOnRow(String row) {
        String trimmedRow = row.trim();
        int leftIndex = row.indexOf(trimmedRow);
        String beforeRow = row.substring(0, leftIndex);

        return beforeRow + CANDLE + trimmedRow + CANDLE;
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
