package ic.cleancodekata.christmastree;

public class OakTree extends AbstractTree implements Tree {

    private final static String BASE = "\\\\//";
    private final static int BASE_HEIGHT = 1;
    private final static int TRUNK_HEIGHT = 2;

    private final int width;
    private final int height;

    public OakTree(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
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
        return 2;
    }
    
    @Override
    protected String buildCanopy() {
        String canopy = "";
        canopy += buildTop();
        canopy += buildMiddle();
        canopy += buildBottom();
        return canopy;
    }

    @Override
    protected String buildBase() {
        int halfWidth = width / 2;
        int halfBase = BASE.length() / 2;
        int beforeBase = halfWidth - halfBase;

        String base = "";
        for (int j = 0; j < beforeBase; j++) {
            base += " ";
        }
        base += BASE + "\n";
        return base;
    }

    private String buildTop() {
        int widthWithoutBorders = width - 2;

        String top = "/";
        for (int j = 0; j < widthWithoutBorders; j++) {
            top += "-";
        }
        top += "\\\n";
        return top;
    }

    private String buildMiddle() {
        int canopyHeight = getCanopyHeight();
        int heightWithoutBorders = canopyHeight - 2;

        String middle = "";
        for (int i = 0; i < heightWithoutBorders; i++) {
            middle += buildMiddleRow();
        }
        return middle;
    }

    private String buildMiddleRow() {
        int widthWithoutBorders = width - 2;

        String middle = "|";
        for (int j = 0; j < widthWithoutBorders; j++) {
            middle += " ";
        }
        middle += "|\n";
        return middle;
    }

    private String buildBottom() {
        int widthWithoutBorders = width - 2;

        String top = "\\";
        for (int j = 0; j < widthWithoutBorders; j++) {
            top += "-";
        }
        top += "/\n";
        return top;
    }
}
