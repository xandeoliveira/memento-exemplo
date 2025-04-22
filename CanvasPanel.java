import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class CanvasPanel extends JPanel {
    private BufferedImage imagem;
    private Graphics2D g2;
    private int prevX, prevY;

    public CanvasPanel(int largura, int altura) {
        imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        g2 = imagem.createGraphics();
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        limpar();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                prevX = e.getX();
                prevY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                g2.drawLine(prevX, prevY, x, y);
                prevX = x;
                prevY = y;
                repaint();
            }
        });
    }

    public void limpar() {
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, imagem.getWidth(), imagem.getHeight());
        g2.setPaint(Color.BLACK);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, null);
    }

    public CanvasMemento salvar() {
        BufferedImage copia = new BufferedImage(
            imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = copia.getGraphics();
        g.drawImage(imagem, 0, 0, null);
        g.dispose();
        return new CanvasMemento(copia);
    }

    public void restaurar(CanvasMemento memento) {
        this.imagem = memento.getEstado();
        this.g2 = imagem.createGraphics();
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        repaint();
    }
}
