import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Officer O1 = new Officer("John Connor", 1, "Sargeant Major", false);
        Officer O2 = new Officer("Lisa Noxville", 1, "Logistic's Commander", true);

        AssignmentType AT1 = new AssignmentType(1, "Seek & Destroy", false);

        Assignment A1 = new Assignment(
                AT1,
                "Seek and destroy as many T800s as possible",
                "2nd Av, Main St.",
                LocalDateTime.of(2099,10,8,11,0),
                LocalDateTime.of(2099,10,9,11,0)
        );

        if(O1.isAdmin()){
            O1.addAssignment(A1);
            O2.addAssignment(A1);
        } else {
            System.out.println("Officer 1 "+ O1.getName() + " is not an admin, unable to add assignments.");
        }

        if(O2.isAdmin()){
            O1.addAssignment(A1);
            O2.addAssignment(A1);
            System.out.println("Officer 2 "+ O2.getName() + " is the " + O2.getPosition()+ ", assignments added.");
        }
    }
}
