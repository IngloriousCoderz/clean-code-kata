package ic.cleancodekata.button;

public class ASCIIButton {

    private final static String EMPTY_CHAR = "";
    private final static String NEWLINE = "\n";
    private final static String SPACE_CHAR = " ";
    private final static String EMPTY_CELL = SPACE_CHAR + SPACE_CHAR;
    private final static String WHOLE_CELL = "*" + SPACE_CHAR;

    private int rows;
    private int columns;
    private String text;

    public static void main(String[] args) {
        System.out.println(new ASCIIButton(10, 10, "hello").build());
    }

    public ASCIIButton(int rows, int columns, String text) {
        this.rows = rows;
        this.columns = columns;
        this.text = text;
    }

    public String build() {
        int rowsWithoutBorders = rows - 2;
        int halfRows = rowsWithoutBorders / 2;
        int halfRowsFixed = halfRows - fixIfEven(rowsWithoutBorders);

        String button = EMPTY_CHAR;
        button += buildWholeRow(columns);
        button += buildEmptyRows(halfRowsFixed, columns);
        button += buildRowWithText(columns, this.text);
        button += buildEmptyRows(halfRows, columns);
        button += buildWholeRow(columns);

        return button;
    }

    private String buildWholeRow(int columns) {
        String row = EMPTY_CHAR;
        for (int j = 0; j < columns; j++) {
            row += WHOLE_CELL;
        }
        row += NEWLINE;

        return row;
    }

    private String buildEmptyRows(int rows, int columns) {
        String emptyRows = EMPTY_CHAR;
        for (int i = 0; i < rows; i++) {
            emptyRows += buildEmptyRow(columns);
        }

        return emptyRows;
    }

    private String buildEmptyRow(int columns) {
        return buildRowWithText(columns, EMPTY_CHAR);
    }

    private String buildRowWithText(int columns, String text) {
        int columnsWithoutBorders = columns - 2;
        float halfColumns = columnsWithoutBorders / 2.0f;
        int charsInHalfColumns = (int) (halfColumns * EMPTY_CELL.length());

        int textLength = text.length();
        int halfText = textLength / 2;
        int halfTextFixed = halfText + fixIfOdd(textLength);

        String rowWithText = EMPTY_CHAR;
        rowWithText += buildLeftOffset(charsInHalfColumns - halfTextFixed);
        rowWithText += text;
        rowWithText += buildRightOffset(charsInHalfColumns - halfText);
        rowWithText += NEWLINE;

        return rowWithText;
    }

    private String buildLeftOffset(int chars) {
        return WHOLE_CELL + buildOffset(chars);
    }

    private String buildRightOffset(int chars) {
        return buildOffset(chars) + WHOLE_CELL;
    }

    private String buildOffset(int chars) {
        String offset = EMPTY_CHAR;
        for (int j = 0; j < chars; j++) {
            offset += SPACE_CHAR;
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
