import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private List<String> riscos = new ArrayList<>();

    public void adicionarRisco(String risco) {
        riscos.add(risco);
    }

    public void mostrarRiscos() {
        System.out.println("Riscos atuais: " + riscos);
    }

    public CanvasMemento start() {
        return new CanvasMemento(new ArrayList<>());
    }

    public CanvasMemento salvar() {
        return new CanvasMemento(new ArrayList<>(riscos));
    }

    public void restaurar(CanvasMemento memento) {
        this.riscos = memento.getEstado();
    }
}
