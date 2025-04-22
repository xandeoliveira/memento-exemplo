public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        CanvasHistory historico = new CanvasHistory();

        canvas.adicionarRisco("");
        historico.salvar(canvas.salvar());
        canvas.mostrarRiscos();

        canvas.adicionarRisco("Risco 1");
        historico.salvar(canvas.salvar());

        canvas.adicionarRisco("Risco 2");
        historico.salvar(canvas.salvar());

        canvas.adicionarRisco("Risco 3");
        historico.salvar(canvas.salvar());

        canvas.mostrarRiscos();

        canvas.restaurar(historico.desfazer()); // desfaz Risco 3
        canvas.mostrarRiscos();
        
        canvas.restaurar(historico.desfazer()); // desfaz Risco 3
        canvas.mostrarRiscos();

        canvas.restaurar(historico.desfazer()); // desfaz Risco 2
        canvas.mostrarRiscos();

        canvas.restaurar(historico.desfazer()); // desfaz Risco 1
        canvas.mostrarRiscos();
    }
}
