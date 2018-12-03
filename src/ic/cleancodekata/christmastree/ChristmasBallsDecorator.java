package ic.cleancodekata.christmastree;

public class ChristmasBallsDecorator implements Tree {

    private final static String AVAILABLE_LIGHTS = "o * ";

    private final Tree tree;

    public ChristmasBallsDecorator(Tree tree) {
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
        String result = tree.build();

        String[] levels = result.split("\n");
        for (int i = 0; i < canopyHeight; i++) {
            levels[i] = buildChristmasLights(levels[i]);
        }

        return String.join("\n", levels);
    }

    private String buildChristmasLights(String level) {
        int leftIndex = level.indexOf("/");
        int rightIndex = level.lastIndexOf("\\");

        if (leftIndex < 0 || rightIndex < 0) {
            return level;
        }

        StringBuilder builder = new StringBuilder(level);
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
