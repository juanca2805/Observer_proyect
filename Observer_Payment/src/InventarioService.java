
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventarioService implements Observer {
    private Map<String, Integer> inventario = new HashMap<>();

    public void agregarProducto(String producto, int cantidad) {
        inventario.put(producto, cantidad);
    }

    public void descontarInventario(String producto, int cantidad) {
        if (inventario.containsKey(producto)) {
            int stockActual = inventario.get(producto);
            int nuevoStock = stockActual - cantidad;
            if (nuevoStock >= 0) {
                inventario.put(producto, nuevoStock);
            } else {
                System.out.println("Error: No hay suficiente stock de " + producto);
            }
        } else {
            System.out.println("Error: El producto " + producto + " no está en el inventario.");
        }
    }

    @Override
    public void actualizar() {
        System.out.println("Notificando al servicio de inventario: Actualizando inventario.");
        
        Map<String, Integer> productosVendidos = obtenerProductosVendidos(); 
        
        for (Map.Entry<String, Integer> entry : productosVendidos.entrySet()) {
            String producto = entry.getKey();
            int cantidad = entry.getValue();
            descontarInventario(producto, cantidad);
        }
    }
    
    private Map<String, Integer> obtenerProductosVendidos() {
        return new HashMap<>();
    }
}
