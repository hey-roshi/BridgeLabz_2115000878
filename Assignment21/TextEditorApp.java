import java.util.Scanner;

class TextState {
    String content;
    TextState next, prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private final int MAX_HISTORY = 10;
    private int size = 0;

    public TextEditor() {
        head = tail = current = null;
    }

    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        
        current = newState;

        if (head == null) {
            head = tail = current;
        } else {
            tail = current; // Update tail to the latest state
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        editor.addTextState("Hello");
        editor.addTextState("Hello, World");
        editor.addTextState("Hello, World!");
        editor.displayCurrentState(); // Output: Hello, World!

        System.out.println("\nPerforming Undo...");
        editor.undo();
        editor.displayCurrentState(); // Output: Hello, World

        System.out.println("\nPerforming Undo...");
        editor.undo();
        editor.displayCurrentState(); // Output: Hello

        System.out.println("\nPerforming Redo...");
        editor.redo();
        editor.displayCurrentState(); // Output: Hello, World

        System.out.println("\nPerforming Redo...");
        editor.redo();
        editor.displayCurrentState(); // Output: Hello, World!
    }
}
