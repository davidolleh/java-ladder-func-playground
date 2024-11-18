package domain;

import java.util.List;

public class Ladder {
    private final List<RowLine> columnLines;

    public Ladder(List<RowLine> columnLines) {
        this.columnLines = columnLines;
    }

    public List<RowLine> getLines() {
        return columnLines;
    }
}
