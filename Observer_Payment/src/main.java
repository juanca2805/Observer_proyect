public class main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        UsuarioService usuarioService = new UsuarioService();
        CarritoDeComprasService carritoService = new CarritoDeComprasService();
        InventarioService inventarioService = new InventarioService();

        paymentService.registrarObservador(usuarioService);
        paymentService.registrarObservador(carritoService);
        paymentService.registrarObservador(inventarioService);

        Producto producto1 = new Producto("Camisa", 25.99);
        Producto producto2 = new Producto("Pantalón", 39.99);
        carritoService.agregarProducto(producto1);
        carritoService.agregarProducto(producto2);

        carritoService.imprimirCarrito();

        paymentService.realizarCompra();
    }
}
