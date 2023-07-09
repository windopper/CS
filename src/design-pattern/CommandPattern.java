import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
    public static void main(String[] args) {

    }
}

abstract class Command {
    protected Editor editor;
    protected String backup;

    public Command(Editor editor) {
        this.editor = editor;
    }

    void saveBackup() {
        backup = editor.text;
    }

    void undo() {
        editor.text = backup;
    }

    abstract void execute();
}

class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    @Override
    void execute() {
        editor.clipBoard = editor.getSelection();
    }
}

class CommandHistory {
    List<Command> history = new ArrayList<>();
}

class Editor {
    public String clipBoard;
    String text;

    public String getSelection() {
        return "";
    }

    public void deleteSelection() {

    }

    public void replaceSelection(String text) {

    }
}

class Application {
    String clipBoard;
    List<Editor> editors = new ArrayList<>();
    Editor activeEditor;
    CommandHistory history;
}
