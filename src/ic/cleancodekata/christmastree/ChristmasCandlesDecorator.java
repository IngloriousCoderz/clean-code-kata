package ic.cleancodekata.christmastree;

public class ChristmasCandlesDecorator implements Tree {

    private final static int CANDLE_WIDTH = 1;

    private final Tree tree;

    public ChristmasCandlesDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public int getWidth() {
        return tree.getWidth() + 2 * CANDLE_WIDTH;
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

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public String build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();

        String result = tree.build();
        String[] rows = result.split("\n");

        String newResult = "";
        newResult += putCandles(rows, canopyHeight);
        newResult += updateRest(rows);

        return newResult;
    }

    private String putCandles(String[] rows, int canopyHeight) {
        String candledCanopy = "";
        for (int i = 0; i < canopyHeight; i++) {
            candledCanopy += putCandlesOnRow(rows[i]);
        }
        return candledCanopy;
    }

    private String putCandlesOnRow(String row) {
        String shiftedRow = shiftRight(row);
        String trimmedRow = row.trim();
        int leftIndex = shiftedRow.indexOf(trimmedRow);

        if (leftIndex < 0) {
            return shiftedRow;
        }

        StringBuilder builder = new StringBuilder(shiftedRow);
        builder.setCharAt(leftIndex - 1, 'i');
        builder.append("i\n");

        return builder.toString();
    }

    private String updateRest(String[] rows) {
        int canopyHeight = getCanopyHeight();
        int baseHeight = getBaseHeight();
        int baseIndex = canopyHeight + baseHeight - 1;

        String base = "";
        for (int i = baseIndex; i < rows.length; i++) {
            base += shiftRight(rows[i]);
            if (i < rows.length - 1) {
                base += "\n";
            }
        }
        return base;
    }

    private String shiftRight(String row) {
        return " " + row;
    }
}
