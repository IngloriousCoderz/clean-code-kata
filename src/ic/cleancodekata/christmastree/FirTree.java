package ic.cleancodekata.christmastree;

public class FirTree implements Tree {

    private final static int BASE_HEIGHT = 1;
    private final static int TRUNK_HEIGHT = 1;

    private final int height;

    public FirTree(int height) {
        this.height = height;
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
    public String build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();

        if (canopyHeight < 1) {
            throw new HeightTooSmallException();
        }

        return buildTree(canopyHeight);
    }

    private String buildTree(int canopyHeight) {
        String tree = "";
        for (int i = 0; i < canopyHeight; i++) {
            tree += buildLeaves(canopyHeight, i);
        }

        int width = canopyHeight * 2;
        tree += buildBase(width);
        tree += buildTrunk(width);

        return tree;
    }

    private String buildLeaves(int canopyHeight, int level) {
        String leaves = "";
        for (int j = 0; j < (canopyHeight - 1 - level); j++) {
            leaves += " ";
        }
        leaves += "/";
        for (int j = 0; j < 2 * level; j++) {
            leaves += " ";
        }
        leaves += "\\\n";
        return leaves;
    }

    private String buildBase(int width) {
        String base = "";
        for (int j = 0; j < width; j++) {
            base += "-";
        }
        base += "\n";
        return base;
    }

    private String buildTrunk(int width) {
        int halfWidth = width / 2;
        int beforeTrunk = halfWidth - 1;

        String trunk = "";
        for (int j = 0; j < beforeTrunk; j++) {
            trunk += " ";
        }
        trunk += "||";
        return trunk;
    }
}
