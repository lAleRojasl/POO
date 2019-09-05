public class Bank {

    //We will mock the check for simplicity, with a pin of (accountNumber + 1)
    //Passwords should never be stored on plain text, always use encryption! (SHA-512) :3
    public static boolean checkAccountData(int accountNumber, int accountPin){
        if(accountPin == accountNumber + 1) return true;
        else return false;
    }

}
