import java.util.ArrayList;
import java.util.List;


public class PaymentService {
    private List<Observer> observadores = new ArrayList<>();

 
    public void registrarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.actualizar();
        }
    }


    public void realizarCompra() {
        System.out.println("Compra realizada con éxito.");
     
        notificarObservadores();
    }
}