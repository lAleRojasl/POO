import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

class Main {

    //Simulation of a "Database"
    private static DatabaseSimulation DBS = new DatabaseSimulation();
    
    public static void main(String[] args) throws IOException, InterruptedException {
        int option = -1;
        String message = "";

        int personalId;
        int accountNumber;
        int accountPin;

        while(true){
            clearScreen();
            System.out.println(message);
            System.out.println("\n-- Menú --");
            System.out.println("1. Sistema: Crear usuario.");
            System.out.println("2. Sistema: Mostrar usuarios.");
            System.out.println("3. Usuario: Reserva cancha.");
            System.out.println("4. Usuario: Ver mis reservas.");
            System.out.println("5. Salir.");

            System.out.print("Ingrese su selección: ");
            Scanner sn = new Scanner(System.in);
            option = sn.nextInt();

            message = "";

            switch(option){
                case 1:
                    System.out.print("Ingresar su name:");
                    sn.nextLine(); //Skip newline (idk why, but needs to be done)
                    String name = sn.nextLine();  // Read user input

                    System.out.print("Ingresar su cedula:");
                    personalId = sn.nextInt();

                    System.out.print("Ingresar su numero de cuenta:");
                    accountNumber = sn.nextInt();

                    //Create User and add it to list of registered Users
                    DBS.addUser(new User(DBS.getUsersSize()+1, name, personalId, accountNumber));
                    message += "Se creó usuario con datos:";
                    message += "\n\tname: "+ name;
                    message += "\n\tCedula: "+personalId;
                    message += "\n\tNumero de Cuenta: "+accountNumber;
                    break;

                case 2:
                    message += "Usuarios registrados: ";
                    for(int i = 0; i < DBS.getUsersSize(); i++){
                        User user = DBS.getUserById(i);
                        message += "\n\tID: "+ user.getId();
                        message += "\t name: "+ user.getName();
                        message += "\t Cedula: "+ user.getPersonalId();
                        message += "\t Numero Cuenta: "+ user.getAccountNumber();
                    }
                    break;


                case 3:
                    System.out.print("Usuario - Ingrese su Cedula: ");
                    personalId = sn.nextInt();  // Read user input
                    if(DBS.getUserByPersonalId(personalId) == null)  {
                        message += "Error: Esa cedula no pertenece a ningun usuario!";
                        break;
                    }

                    System.out.print("Usuario - Ingrese Fecha y Hora (yyyy-MM-dd HH:mm): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    sn.nextLine();
                    LocalDateTime startDateTime = LocalDateTime.parse(sn.nextLine(), formatter);

                    System.out.print("Usuario - Ingrese Id de Cancha: ");
                    int fieldId = sn.nextInt();  // Read user input

                    //We check if there are no other reservations at this time
                    if(!DBS.checkAvailability(startDateTime, fieldId)){
                        message += "Error: Ya hay una reservacion a esa hora en esa cancha!";
                        break;
                    };

                    System.out.print("Usuario - Campo disponible, ingrese su PIN para realizar pago (# de Cuenta + 1): ");
                    accountPin = sn.nextInt();  // Read user input
                    accountNumber = DBS.getUserByPersonalId(personalId).getAccountNumber();
                    //Incorrect PIN - Payment failed
                    if(!Bank.checkAccountData(accountNumber, accountPin)){
                        message += "Error: Banco rechazo transaccion por PIN incorrecto!";
                        break;
                    }

                    Reservation reservation = new Reservation(DBS.getReservationSize()+1, personalId, startDateTime, fieldId);
                    DBS.addReservation(reservation);
                    message += "Se creó la siguiente reserva exitosamente: ";
                    message += "\n\tOwner: "+DBS.getUserByPersonalId(personalId).getName();
                    message += "\n\tStart Date: "+reservation.getStartDateTime();
                    message += "\n\tEnd Date: "+reservation.getEndDateTime();
                    message += "\n\tField Id: "+reservation.getFieldId();
                    break;

                case 4:
                    System.out.print("Usuario - Ingrese su Cedula: ");
                    personalId = sn.nextInt();  // Read user input
                    if(DBS.getUserByPersonalId(personalId) == null)  {
                        message += "Error. Esa cedula no pertenece a ningun usuario!";
                        break;
                    }

                    ArrayList<Reservation> reservationsForUser = DBS.getReservationsForUser(personalId);
                    String userName = DBS.getUserByPersonalId(personalId).getName();
                    message += userName + ", estas son tus reservas: ";
                    for(int i = 0; i < reservationsForUser.size(); i++){
                        reservation = reservationsForUser.get(i);
                        message += "\n\tID: "+ reservation.getId();
                        message += "\t Fecha Inicio: "+ reservation.getStartDateTime();
                        message += "\t Fecha Final: "+ reservation.getEndDateTime();
                        message += "\t Numero Cancha: "+ reservation.getFieldId();
                    }
                    break;

                case 5:
                    System.out.println("Deteniendo Programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opción "+ option +" es invalida!");
                    break;

            }
        }
    }

    //This basically clears the console.
    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}