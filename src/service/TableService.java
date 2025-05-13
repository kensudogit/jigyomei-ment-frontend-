import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    public TableData moveRows(List<Integer> selectedRows, int targetRow) {
        // テーブルデータを取得
        TableData tableData = getTableData();

        // エラーチェック: 選択行または移動先行が無効な場合
        if (selectedRows == null || selectedRows.isEmpty()) {
            throw new InvalidMoveException("Selected rows cannot be null or empty.");
        }
        if (targetRow < 0 || targetRow > tableData.getRows().size()) {
            throw new InvalidMoveException("Target row is out of bounds.");
        }

        // 選択された行を移動
        List<Row> rows = tableData.getRows();
        List<Row> selected = new ArrayList<>();
        for (Integer rowIndex : selectedRows) {
            if (rowIndex < 0 || rowIndex >= rows.size()) {
                throw new InvalidMoveException("Selected row index is out of bounds: " + rowIndex);
            }
            selected.add(rows.get(rowIndex));
        }
        rows.removeAll(selected);
        rows.addAll(targetRow, selected);

        // 更新されたテーブルデータを返す
        return tableData;
    }

    private TableData getTableData() {
        // ここで実際のテーブルデータを取得するロジックを実装
        return new TableData();
    }
}