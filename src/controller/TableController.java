import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/table")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/move")
    public ResponseEntity<TableData> moveRows(@RequestBody MoveRequest request) {
        try {
            TableData updatedTable = tableService.moveRows(request.getSelectedRows(), request.getTargetRow());
            return ResponseEntity.ok(updatedTable);
        } catch (InvalidMoveException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/addRow")
    public ResponseEntity<Void> addRow() {
        // 行データの追加
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateDatabase")
    public ResponseEntity<Void> updateDatabase() {
        // データベース更新
        return ResponseEntity.ok().build();
    }

    @PostMapping("/undo")
    public ResponseEntity<Void> undo() {
        // 取り消し
        return ResponseEntity.ok().build();
    }

    @PostMapping("/moveUp")
    public ResponseEntity<Void> moveUp() {
        // 項目の上の行への移動
        return ResponseEntity.ok().build();
    }

    @PostMapping("/moveDown")
    public ResponseEntity<Void> moveDown() {
        // 項目の下の行への移動
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete() {
        // 削除
        return ResponseEntity.ok().build();
    }

    @PostMapping("/changeCondition")
    public ResponseEntity<Void> changeCondition() {
        // 条件指定の変更
        return ResponseEntity.ok().build();
    }

    @PostMapping("/finish")
    public ResponseEntity<Void> finish() {
        // 終了
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(InvalidMoveException.class)
    public ResponseEntity<String> handleInvalidMoveException(InvalidMoveException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}