import java.util.Stack;

public class CanvasHistory {
    private final Stack<CanvasMemento> historico = new Stack<>();

    public void salvar(CanvasMemento memento) {
        historico.push(memento);
    }

    public CanvasMemento desfazer() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }
}
