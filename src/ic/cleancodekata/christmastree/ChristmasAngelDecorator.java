package ic.cleancodekata.christmastree;

public class ChristmasAngelDecorator implements Tree {
    private final static int ANGEL_HEIGHT = 1;
    
    private final Tree tree;

    public ChristmasAngelDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public int getCanopyHeight() {
        return tree.getCanopyHeight() + ANGEL_HEIGHT;
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
        String result = tree.build();

        String[] levels = result.split("\n");
        int maxWidth = getMaxWidth(levels);
        String angelLevel = buildAngel(maxWidth);

        return angelLevel + String.join("\n", levels);
    }
    
    private int getMaxWidth(String[] levels) {
        int maxWidth = 0;
        for (int i = 0; i < levels.length; i++) {
            int width = levels[i].length();
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
    
    private String buildAngel(int treeWidth) {
        int halfWidth = treeWidth / 2;
        String angelLevel = "";
        for (int j = 0; j < halfWidth - 1; j++) {
            angelLevel += " ";
        }
        angelLevel += "qp\n";
        return angelLevel;
    }
}
