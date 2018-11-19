package ic.cleancodekata.quadrato;

public class ASCIIButton {

    private int rows;
    private int columns;

    public static void main(String[] args) {
        System.out.println(new ASCIIButton(10, 10).build("hello"));
    }

    public ASCIIButton(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public String build(String text) {
        int rowsWithoutBorders = rows - 2;
        int halfRows = rowsWithoutBorders / 2;
        int halfRowsFixed = halfRows - fixIfEven(rowsWithoutBorders);

        String button = "";
        button += buildWholeRow(columns);
        button += buildEmptyRows(halfRowsFixed, columns);
        button += buildRowWithText(columns, text);
        button += buildEmptyRows(halfRows, columns);
        button += buildWholeRow(columns);

        return button;
    }

    private String buildWholeRow(int columns) {
        String row = "";
        for (int j = 0; j < columns; j++) {
            row += "* ";
        }
        row += "\n";

        return row;
    }

    private String buildEmptyRows(int rows, int columns) {
        String emptyRows = "";
        for (int i = 0; i < rows; i++) {
            emptyRows += buildEmptyRow(columns);
        }

        return emptyRows;
    }

    private String buildEmptyRow(int columns) {
        return buildRowWithText(columns, "");
    }

    private String buildRowWithText(int columns, String text) {
        int columnsWithoutBorders = columns - 2;
        float halfColumns = columnsWithoutBorders / 2.0f;
        int charsInHalfColumns = (int) (halfColumns * 2);

        int textLength = text.length();
        int halfText = textLength / 2;
        int halfTextFixed = halfText + fixIfOdd(textLength);

        String rowWithText = "";
        rowWithText += buildLeftOffset(charsInHalfColumns - halfTextFixed);
        rowWithText += text;
        rowWithText += buildRightOffset(charsInHalfColumns - halfText);
        rowWithText += "\n";

        return rowWithText;
    }

    private String buildLeftOffset(int chars) {
        return "* " + buildOffset(chars);
    }

    private String buildRightOffset(int chars) {
        return buildOffset(chars) + "* ";
    }

    private String buildOffset(int chars) {
        String offset = "";
        for (int j = 0; j < chars; j++) {
            offset += " ";
        }
        return offset;
    }

    private int fixIfEven(int quantity) {
        return quantity % 2 == 0 ? 1 : 0;
    }

    private int fixIfOdd(int quantity) {
        return quantity % 2 == 0 ? 0 : 1;
    }
}
