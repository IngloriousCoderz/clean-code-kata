package ic.cleancodekata.christmastree;

public class ChristmasAngelDecorator implements Tree {

    private final static int ANGEL_HEIGHT = 1;

    private final Tree tree;

    public ChristmasAngelDecorator(Tree tree) {
        this.tree = tree;
    }

    @Override
    public int getWidth() {
        return tree.getWidth();
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
    public int getMinimumAllowedCanopyHeight() {
        return tree.getMinimumAllowedCanopyHeight();
    }

    @Override
    public String build() throws HeightTooSmallException {
        String result = tree.build();

        String[] rows = result.split("\n");
        String angelLevel = buildAngel();

        return angelLevel + String.join("\n", rows);
    }

    private String buildAngel() {
        int halfWidth = getWidth() / 2;
        String angelRow = "";
        for (int j = 0; j < halfWidth - 1; j++) {
            angelRow += " ";
        }
        angelRow += "qp\n";
        return angelRow;
    }
}
