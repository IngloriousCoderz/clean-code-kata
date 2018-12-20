package ic.cleancodekata.christmastree;

import java.util.ArrayList;
import java.util.List;

public class ChristmasBallsDecorator implements Tree {

    private final static String AVAILABLE_LIGHTS = "o * ";

    private final Tree tree;

    public ChristmasBallsDecorator(Tree tree) {
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
    public List<String> buildCanopy() throws HeightTooSmallException {
        return putChristmasBalls(tree.buildCanopy());
    }

    private List<String> putChristmasBalls(List<String> rows) {
        List<String> newRows = new ArrayList();
        for (int i = 0; i < rows.size(); i++) {
            newRows.add(putChristmasBallsOnRow(rows.get(i)));
        }
        return newRows;
    }

    private String putChristmasBallsOnRow(String row) {
        String[] tokens = row.split("[^\\s]+");

        if (!isEmptyRow(tokens)) {
            return row;
        }

        String insideCanopy = tokens[1];
        int leftIndex = row.indexOf(insideCanopy);
        int rightIndex = leftIndex + insideCanopy.length() - 1;

        StringBuilder builder = new StringBuilder(row);
        for (int j = leftIndex + 1; j < rightIndex; j++) {
            char randomLight = chooseRandomLight();
            builder.setCharAt(j, randomLight);
        }

        return builder.toString();
    }

    private boolean isEmptyRow(String[] tokens) {
        return tokens.length == 2;
    }

    private char chooseRandomLight() {
        int index = (int) (Math.random() * AVAILABLE_LIGHTS.length());
        return AVAILABLE_LIGHTS.charAt(index);
    }

    @Override
    public List<String> buildBase() {
        return tree.buildBase();
    }

    @Override
    public List<String> buildTrunk() {
        return tree.buildTrunk();
    }

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public int getWidth() {
        return tree.getWidth();
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
