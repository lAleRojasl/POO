import java.time.LocalDateTime;

/*
-------------------------------
| Autor: Alejandro Rojas Jara |
| Curso: POO                  |
| Fecha: 22/08/2019           |
-------------------------------
*/

class Cuenta {
    private int id;
    private double balance;
    private double anualInterestRate;
    private LocalDateTime dateOfCreation;

    //Default Constructor
    public Cuenta() {
        this.id = 0;
        this.balance = 0.0d;
        this.anualInterestRate = 0.0d;
        this.dateOfCreation = LocalDateTime.now();
    }

    //Parameterized Constructor
    public Cuenta(int id, double balance) {
        this.id = id;
        this.balance = balance;
        //Por simplicidad, representamos porcentajes en punto flotante 4.5/100 -> 0.045d;
        this.anualInterestRate = 0.045d;
        this.dateOfCreation = LocalDateTime.now();
    }

    //METHODS
    public double getMonthlyInterestRate() { return  this.anualInterestRate  / 12;  }

    public double calculateMonthlyInterest() { return this.balance * getMonthlyInterestRate();   }

    public void withdrawCash(double withdrawalAmount){
        this.balance -= withdrawalAmount;
    }

    public void depositCash(double depositAmount){
        this.balance += depositAmount;
    }

    //GETTERS
    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getAnualInterestRate() {
        return this.anualInterestRate ;
    }

    public LocalDateTime getFechaDeCreacion() {
        return this.dateOfCreation;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnualInterestRate() {
        this.anualInterestRate = anualInterestRate;
    }

}
