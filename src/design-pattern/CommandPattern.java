import java.util.ArrayList;
import java.util.List;

public class CommandPattern {
    public static CommandHistory history = new CommandHistory();
    public static void main(String[] args) {
        Editor editor = new Editor();
        Runnable copy = () -> {
            executeCommand(new CopyCommand(editor));
        };
        Runnable cut = () -> {
            executeCommand(new CutCommand(editor)); 
        };
        Runnable undo = () -> {
            executeCommand(new UndoCommand(editor));    
        };
    }

    public static void executeCommand(Command c) {
        c.execute();
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
    public void execute() {
        editor.clipBoard = editor.getSelection();
    }
}

class CutCommand extends Command {
    public CutCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        saveBackup();
        editor.clipBoard = editor.getSelection();
        editor.deleteSelection();
    }
}

class UndoCommand extends Command {
    public UndoCommand(Editor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        undo();
    }
}

class CommandHistory {
    List<Command> history = new ArrayList<>();

    public void push(Command c) {
        history.add(c);
    }

    public Command pop() {
        if(history.size() >= 1) {
            Command ret;
            ret = history.get(0);
            history.remove(0);
            return ret;
        }
        return null;
    }
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
