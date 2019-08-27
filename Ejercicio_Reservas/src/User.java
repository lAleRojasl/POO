public class User {
    private int id;
    private String name;
    private int personalId;
    private int accountNumber;

    //Parameterized Constructor
    public User(int id, String name, int personalId, int accountNumber){
        this.id = id;
        this.name = name;
        this.personalId = personalId;
        this.accountNumber = accountNumber;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPersonalId() {
        return personalId;
    }

    public int getAccountNumber() {  return accountNumber;  }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(int accountNumber) {  this.accountNumber = accountNumber;  }
}
