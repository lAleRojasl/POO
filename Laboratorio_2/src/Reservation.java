import java.time.LocalDateTime;

public class Reservation {
    private int id; //Id de la reserva
    private LocalDateTime startDateTime; //Hora de Inicio
    private LocalDateTime endDateTime; //Hora de Fin
    private int fieldId; //Id de la cancha reservada
    private int userId; //Id del reservante

    public Reservation(int id, int userId, LocalDateTime startDateTime, int fieldId){
        this.id = id;
        this.userId = userId;
        this.startDateTime = startDateTime;
        //We will default reservation time to 1 hour, so it's not needed to input it.
        this.endDateTime = startDateTime.plusHours(1);
        this.fieldId = fieldId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {  return userId;  }

    public void setUserId(int userId) {  this.userId = userId;  }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }
}
