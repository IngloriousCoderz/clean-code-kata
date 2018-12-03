package ic.cleancodekata.christmastree;

public class ChristmasCandlesDecorator implements Tree {

    private final Tree tree;

    public ChristmasCandlesDecorator(Tree tree) {
        this.tree = tree;
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
    public String build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();
        int baseHeight = getBaseHeight();
        int trunkHeight = getTrunkHeight();

        String result = tree.build();

        String[] levels = result.split("\n");
        for (int i = 0; i < canopyHeight; i++) {
            levels[i] = buildCandles(levels[i]);
        }

        String base = levels[canopyHeight + baseHeight - 1];
        levels[canopyHeight + baseHeight - 1] = shiftRight(base);

        String trunk = levels[canopyHeight + baseHeight + trunkHeight - 1];
        levels[canopyHeight + baseHeight + trunkHeight - 1] = shiftRight(trunk);

        return String.join("\n", levels);
    }

    private String buildCandles(String level) {
        String shiftedLevel = shiftRight(level);
        int leftIndex = shiftedLevel.indexOf("/");

        if (leftIndex < 0) {
            return shiftedLevel;
        }
        
        StringBuilder builder = new StringBuilder(shiftedLevel);
        builder.setCharAt(leftIndex - 1, '|');
        builder.append('|');

        return builder.toString();
    }

    private String shiftRight(String level) {
        return " " + level;
    }
}
