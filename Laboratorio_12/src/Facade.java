public class Facade {

    private Bank bank = new Bank();
    private Shipping shipping = new Shipping();
    private Invoice invoice = new Invoice();

    public Facade(){
        System.out.println("Servicio de Facade activo.");
    }

    public void procesarCompra(){
        bank.procesarPago();
        bank.cerrarConexion();
        shipping.procesarEnvio();
        invoice.procesarFactura();
    }
}
