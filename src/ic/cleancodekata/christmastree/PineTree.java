package ic.cleancodekata.christmastree;

import java.util.ArrayList;
import java.util.List;

public class PineTree extends AbstractTree implements Tree {

    private final static String CANOPY_LEFT = "/";
    private final static String CANOPY_RIGHT = "\\";
    private final static String BASE = "-";
    private final static String TRUNK = "||";

    private final static int BASE_HEIGHT = 1;
    private final static int TRUNK_HEIGHT = 1;

    private final int height;

    public PineTree(int height) {
        this.height = height;
    }

    @Override
    public List<String> buildCanopy() {
        List<String> canopy = new ArrayList();
        for (int i = 0; i < getCanopyHeight(); i++) {
            canopy.add(buildCanopyRow(i));
        }
        return canopy;
    }

    private String buildCanopyRow(int row) {
        int canopyHeight = getCanopyHeight();
        int beforeCanopy = canopyHeight - 1 - row;
        int insideCanopy = 2 * row;

        String leaves = EMPTY_STRING;
        for (int j = 0; j < beforeCanopy; j++) {
            leaves += SPACE;
        }
        leaves += CANOPY_LEFT;
        for (int j = 0; j < insideCanopy; j++) {
            leaves += SPACE;
        }
        leaves += CANOPY_RIGHT;
        return leaves;
    }

    @Override
    protected String buildBaseRow() {
        String base = EMPTY_STRING;
        for (int j = 0; j < getWidth(); j++) {
            base += BASE;
        }
        return base;
    }

    @Override
    protected String buildTrunkRow() {
        int halfWidth = getWidth() / 2;
        int halfTrunk = TRUNK.length() / 2;
        int beforeTrunk = halfWidth - halfTrunk;

        String trunk = EMPTY_STRING;
        for (int j = 0; j < beforeTrunk; j++) {
            trunk += SPACE;
        }
        trunk += TRUNK;
        return trunk;
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return 1;
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
}
