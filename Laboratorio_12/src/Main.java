
public class Main {

    public static void main(String[] args) {

        Facade facade = new Facade(); 	//Inicializar Fachada
        System.out.println("\n- Cliente realizando compra:");
        facade.procesarCompra();	//Operacion simplificada de la operacion "Comprar"

    }

}
