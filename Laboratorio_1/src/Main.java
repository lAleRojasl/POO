import java.time.format.DateTimeFormatter;

/*
-------------------------------
| Autor: Alejandro Rojas Jara |
| Curso: POO                  |
| Fecha: 22/08/2019           |
-------------------------------
*/

class Main {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        Cuenta c1 = new Cuenta(1122, 500000.0d);

        System.out.println("Cuenta 1 creada con los siguientes parametros:"
                +"\n\t- ID: " + c1.getId()
                +"\n\t- Balance: " + c1.getBalance()
                +"\n\t- Tasa de Interes Anual: " + c1.getAnualInterestRate() * 100 + "%"
                +"\n\t- Fecha de Creación: " + dtf.format(c1.getFechaDeCreacion()) );

        System.out.println("\nDepositando 150000 CRC a la cuenta...");
        c1.depositCash(150000.0d);
        System.out.println("\t-Nuevo Balance: " + c1.getBalance() );

        System.out.println("\nRetirando 200000 CRC de la cuenta...");
        c1.withdrawCash(200000.0d);
        System.out.println("\tNuevo Balance: " + c1.getBalance() );

        System.out.println("Estado de Cuenta:"
                +"\n\t- Balance: " + c1.getBalance()
                +"\n\t- Tasa de Interes Mensual: " + c1.getMonthlyInterestRate() * 100 + "%"
                +"\n\t- Interes Mensual: " + c1.calculateMonthlyInterest()
                +"\n\t- Fecha de Creación: " + dtf.format(c1.getFechaDeCreacion()) );

        Cuenta c2 = new Cuenta(2233, 1000000.0d);

        System.out.println("\n\nCuenta 2 creada con los siguientes parametros:"
                +"\n\t- ID: " + c2.getId()
                +"\n\t- Balance: " + c2.getBalance()
                +"\n\t- Tasa de Interes Mensual: " + c1.getMonthlyInterestRate() * 100 + "%"
                +"\n\t- Interes Mensual: " + c1.calculateMonthlyInterest()
                +"\n\t- Fecha de Creación: " + dtf.format(c2.getFechaDeCreacion()) );

        //Create ATM Simulator
        new ATM();
    }

}

//  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
