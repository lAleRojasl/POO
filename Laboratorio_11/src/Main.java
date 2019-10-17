import java.util.ArrayList;

/**********************************************************************
 Instituto Tecnológico de Costa Rica
 Estructuras de Datos IC-2001
 II Semestre 2018
 Profesora: Samanta Ramijan Carmiol

 Ejemplos Prácticos: Aplicacion Completa
 **********************************************************************/
public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado("Rojas Market");
        AdministradorArchivo archAdmin = new AdministradorArchivo(supermercado);
        archAdmin.readXSLFile();
        supermercado.imprimirInventario();
    }
}
