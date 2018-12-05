package ic.cleancodekata.christmastree;

public class ChristmasBallsDecorator implements Tree {

    private final static String AVAILABLE_LIGHTS = "o * ";

    private final Tree tree;

    public ChristmasBallsDecorator(Tree tree) {
        this.tree = tree;
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

    @Override
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public String build() throws HeightTooSmallException {
        int canopyHeight = getCanopyHeight();
        String result = tree.build();

        String[] rows = result.split("\n");
        for (int i = 0; i < canopyHeight; i++) {
            rows[i] = buildChristmasLights(rows[i]);
        }

        return String.join("\n", rows);
    }

    private String buildChristmasLights(String row) {
        String[] tokens = row.split("[^\\s]+");

        if (tokens.length != 2) {
            return row;
        }

        String insideOfCanopy = tokens[1];
        int leftIndex = row.indexOf(insideOfCanopy);
        int rightIndex = leftIndex + insideOfCanopy.length() - 1;

        if (leftIndex < 0) {
            return row;
        }

        StringBuilder builder = new StringBuilder(row);
        for (int j = leftIndex + 1; j < rightIndex; j++) {
            char randomLight = chooseRandomLight();
            builder.setCharAt(j, randomLight);
        }

        return builder.toString();
    }

    private char chooseRandomLight() {
        int index = (int) (Math.random() * AVAILABLE_LIGHTS.length());
        return AVAILABLE_LIGHTS.charAt(index);
    }
}
