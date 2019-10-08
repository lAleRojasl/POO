import java.util.ArrayList;

public class Officer {

    //Attributes
    private String name;
    private int officerId;
    private String position;
    private boolean isAdmin;
    private ArrayList<Assignment> assignments;

    //Constructor

    public Officer(String name, int officerId, String position, boolean isAdmin) {
        this.name = name;
        this.officerId = officerId;
        this.position = position;
        this.isAdmin = isAdmin;
        this.assignments = new ArrayList<>();
    }

    public boolean isAdmin(){
        return isAdmin;
    }

    public String getName(){
        return this.name;
    }

    public String getPosition(){
        return this.position;
    }

    public ArrayList<Assignment> requestAssignments(){
        return this.assignments;
    }

    public void addAssignment(Assignment asgnmt){
        this.assignments.add(asgnmt);
    }

    public void completeAssignment(Assignment asgnmt){
        this.assignments.remove(asgnmt);
    }

}
