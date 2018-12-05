package ic.cleancodekata.christmastree;

public class PineTree extends AbstractTree implements Tree {

    private final static int BASE_HEIGHT = 1;
    private final static int TRUNK_HEIGHT = 1;

    private final int height;

    public PineTree(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return getCanopyHeight() * 2;
    }

    @Override
    public int getCanopyHeight() {
        return height - getBaseHeight() - getTrunkHeight();
    }

    @Override
    public int getBaseHeight() {
        return BASE_HEIGHT;
    }

    @Override
    public int getTrunkHeight() {
        return TRUNK_HEIGHT;
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return 1;
    }

    @Override
    protected String buildCanopy() {
        int canopyHeight = getCanopyHeight();

        String canopy = "";
        for (int i = 0; i < canopyHeight; i++) {
            canopy += buildCanopyRow(i);
        }
        return canopy;
    }

    private String buildCanopyRow(int row) {
        int canopyHeight = getCanopyHeight();

        String leaves = "";
        for (int j = 0; j < (canopyHeight - 1 - row); j++) {
            leaves += " ";
        }
        leaves += "/";
        for (int j = 0; j < 2 * row; j++) {
            leaves += " ";
        }
        leaves += "\\\n";
        return leaves;
    }

    @Override
    protected String buildBase() {
        int width = getWidth();

        String base = "";
        for (int j = 0; j < width; j++) {
            base += "-";
        }
        base += "\n";
        return base;
    }
}
