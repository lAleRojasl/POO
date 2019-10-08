import java.time.LocalDateTime;

public class Assignment {

    private AssignmentType assignmentType;
    private String description;
    private String address;
    private LocalDateTime start;
    private LocalDateTime end;

    public Assignment(AssignmentType assignmentType, String description, String address, LocalDateTime start, LocalDateTime end) {
        this.assignmentType = assignmentType;
        this.description = description;
        this.address = address;
        this.start = start;
        this.end = end;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
