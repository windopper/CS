public class MementoPattern {
    public static void main(String[] args) {

    }
}

// 오리지네이터는 시간이 지남에 따라 변경될 수 있는 어떤 중요한 데이터를
// 보유한다.
// 또한 자신의 상태를 메멘토 내부에 저장하는 메서드와 해당 상태를
// 메멘토로부터 복원하는 또 다른 메서드를 정의한다
class Editor {
    private String text;
    private double curX, curY, selectionWidth;

    public void setText(String text) {
        this.text = text;
    }

    public void setCursor(double x, double y) {
        this.curX = x;
        this.curY = y;
    }

    public void setSelectionWidth(double width) {
        this.selectionWidth = width;
    }

    // 현재 상태를 메멘토 내부에 정의한다
    public Snapshot createSnapshot() {
        return new Snapshot(this, text, curX, curY, selectionWidth);
    }
}

class Snapshot {
    private Editor editor;
    private String text;
    private double curX, curY, selectionWidth;

    public Snapshot(Editor editor, String text, double curX, double curY, double selectionWidth) {
        this.editor = editor;
        this.text = text;
        this.curX = curX;
        this.curY = curY;
        this.selectionWidth = selectionWidth;
    }

    // 어느 시점에 메멘토 객체를 사용하여 편집기의 이전 상태를 복원할 수 있다.
    public void restore() {
        editor.setText(text);
        editor.setCursor(curX, curY);
        editor.setSelectionWidth(selectionWidth);
    }
}

// 커맨드 객체는 케어테이커 역할을 할 수 있다.
// 그러면 커맨드는 오리지네이터의 상태를 변경하지 직전에 메멘토를 얻는다.
// 실행 취소가 요청되면 캐먼드는 메멘토에서 오리지 네이터의 상태를 복원한다.
class Command {
    private Snapshot backup;
    private Editor editor;

    public Command(Editor editor) {
        this.backup = editor.createSnapshot();
        this.editor = editor;
    }

    public void makeBackup() {
        backup = editor.createSnapshot();
    }

    public void undo() {
        if (backup != null)
            backup.restore();
    }
}
