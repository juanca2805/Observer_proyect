import java.util.ArrayList;
import java.util.List;

public class CarritoDeComprasService implements Observer {
 private List<Producto> carrito = new ArrayList<>();

 public void agregarProducto(Producto producto) {
     carrito.add(producto);
 }

 public void vaciarCarrito() {
     carrito.clear();
 }

 public void imprimirCarrito() {
     System.out.println("Productos en el carrito:");
     for (Producto producto : carrito) {
         System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
     }
 }

 @Override
 public void actualizar() {
     System.out.println("Notificando al servicio de carrito de compras: Eliminando productos del carrito.");
     vaciarCarrito();
 }
}
