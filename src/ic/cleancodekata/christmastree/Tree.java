package ic.cleancodekata.christmastree;

public interface Tree {

    public int getWidth();

    public int getCanopyHeight();

    public int getBaseHeight();

    public int getTrunkHeight();
    
    public String build() throws HeightTooSmallException;
    
    public int getMinimumAllowedCanopyHeight();
}
