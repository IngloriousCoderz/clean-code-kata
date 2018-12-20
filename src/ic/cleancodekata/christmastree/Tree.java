package ic.cleancodekata.christmastree;

import java.util.List;

public interface Tree {

    public final static String EMPTY_STRING = "";
    public final static String SPACE = " ";
    public final static String NEWLINE = "\n";

    public List<String> build() throws HeightTooSmallException;

    public List<String> buildCanopy();

    public List<String> buildBase();

    public List<String> buildTrunk();

    public int getMinimumAllowedCanopyHeight();

    public int getWidth();

    public int getCanopyHeight();

    public int getBaseHeight();

    public int getTrunkHeight();
}
