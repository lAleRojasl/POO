import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatabaseSimulation {

    //List of registered users
    private ArrayList<User> users = new ArrayList<>();

    //List of reservations
    private ArrayList<Reservation> reservations = new ArrayList<>();

    // Reservations
    //--------------
    //Add a reservation to our list.
    public void addReservation(Reservation newReservation){
        this.reservations.add(newReservation);
    }

    //Get all the reservations for a specific user
    public ArrayList<Reservation> getReservationsForUser(int userId){
        ArrayList<Reservation> reservationsForUser = new ArrayList<>();
        for(int i = 0; i < reservations.size(); i++) {
            if(reservations.get(i).getUserId() == userId) reservationsForUser.add(reservations.get(i));
        }
        return reservationsForUser;
    }

    //Get count/size of registered users
    public int getReservationSize(){
        return this.reservations.size();
    }


    public boolean checkAvailability(LocalDateTime startDateTime, int fieldId){
        for(int i = 0; i < this.reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            //There's a reservation on that field.
            if(reservation.getFieldId() == fieldId){
                //At the same time
                if(reservation.getStartDateTime().isEqual(startDateTime)){
                    return false;
                }
            }
        }
        //No conflicts, time available.
        return true;
    }
    // Users
    //-------
    //Add a user to our list
    public void addUser(User user){
        this.users.add(user);
    }

    //Get a specific User by their personalId
    public User getUserByPersonalId(int personalId){
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getPersonalId() == personalId) return this.users.get(i);
        }
        //not found
        return null;
    }

    public User getUserById(int id){
        return this.users.get(id);
    }

    //Get count/size of registered users
    public int getUsersSize(){
        return this.users.size();
    }

}
