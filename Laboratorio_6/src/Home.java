import Rooms.Room;

import java.util.ArrayList;

public class Home {
    private String owners;
    private ArrayList<Room> rooms;

    public Home(){
        this.rooms = new ArrayList<>();
    }

    public Home(String owners){
        this.rooms = new ArrayList<>();
        this.owners = owners;
    }

    public void addRoom(Room newRoom){
        this.rooms.add(newRoom);
    }

    public int roomCount(){
        return this.rooms.size();
    }

    public Room getRoom(int roomIndex){
        return this.rooms.get(roomIndex);
    }

    public Room getRoom(String roomName){
        for (Room r:
             rooms) {
            if(r.getName() == roomName){
                return r;
            }
        }
        return null;
    }

}
