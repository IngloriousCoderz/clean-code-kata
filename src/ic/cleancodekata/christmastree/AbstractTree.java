package ic.cleancodekata.christmastree;

public abstract class AbstractTree implements Tree {

    @Override
    public String build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();
        int miniumAllowedCanopyHeight = getMinimumAllowedCanopyHeight();

        if (canopyHeight < miniumAllowedCanopyHeight) {
            throw new HeightTooSmallException();
        }

        return buildTree();
    }

    private String buildTree() {
        String tree = "";
        tree += buildCanopy();
        tree += buildBase();
        tree += buildTrunk();
        return tree;
    }

    protected abstract String buildCanopy();

    protected abstract String buildBase();

    private String buildTrunk() {
        int trunkHeight = getTrunkHeight();

        String trunk = "";
        for (int i = 0; i < trunkHeight; i++) {
            trunk += buildTrunkRow();
            if (i < trunkHeight - 1) {
                trunk += "\n";
            }
        }
        return trunk;
    }

    private String buildTrunkRow() {
        int width = getWidth();
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
