import java.util.List;

public class CanvasMemento {
    private final List<String> estado;

    public CanvasMemento(List<String> estado) {
        this.estado = estado;
    }

    public List<String> getEstado() {
        return estado;
    }
}
