class Spreadsheet {

    private final int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[26][rows];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[col][row] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[col][row] = 0;
    }

    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");

        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    private int getOperandValue(String operand) {
        char first = operand.charAt(0);
        if (Character.isDigit(first)) {
            return Integer.parseInt(operand);
        } else {
            int col = first - 'A';
            int row = Integer.parseInt(operand.substring(1)) - 1;
            return sheet[col][row];
        }
    }
}