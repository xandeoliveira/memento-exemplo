import java.awt.image.BufferedImage;

public class CanvasMemento {
    private final BufferedImage estado;

    public CanvasMemento(BufferedImage estado) {
        this.estado = estado;
    }

    public BufferedImage getEstado() {
        return estado;
    }
}
