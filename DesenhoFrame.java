import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesenhoFrame extends JFrame {
    private final CanvasPanel canvas;
    private final CanvasHistory history;

    @SuppressWarnings("unused")
    public DesenhoFrame() {
        super("App de Rabiscos (Memento)");

        canvas = new CanvasPanel(800, 600);
        history = new CanvasHistory();

        JButton btnDesfazer = new JButton("Desfazer");
        JButton btnLimpar = new JButton("Limpar");

        btnDesfazer.addActionListener(e -> {
            CanvasMemento memento = history.desfazer();
            if (memento != null) {
                canvas.restaurar(memento);
            } else {
                JOptionPane.showMessageDialog(this, "Nada a desfazer.");
            }
        });

        btnLimpar.addActionListener(e -> {
            history.salvar(canvas.salvar());
            canvas.limpar();
        });

        canvas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                history.salvar(canvas.salvar());
            }
        });

        JPanel botoes = new JPanel();
        botoes.add(btnDesfazer);
        botoes.add(btnLimpar);

        add(canvas, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setSize(820, 670);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
