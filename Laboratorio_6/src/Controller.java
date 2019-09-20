import Devices.Device;
import Rooms.Room;

public class Controller {
    private Home myHome;

    public Controller(){
        myHome = new Home("Default Home");
    }

    public Controller(Home home){
        myHome = home;
    }

    public void switchEverything(boolean newState){
        int roomCount = myHome.roomCount();
        System.out.println("\nThere are " + roomCount + " rooms in this House!");
        //lets traverse all rooms
        for (int i = 0; i < roomCount; i++) {
            Room someRoom = myHome.getRoom(i);

            System.out.println("\nI'm on room --> " + someRoom.getName());
            int deviceCount = someRoom.deviceCount();

            if(deviceCount > 0)
                System.out.println("Ooh there are " + deviceCount + " devices in here!");
            else
                System.out.println("Aww no devices in here...");

            for (int j = 0; j < deviceCount ; j++) {
                Device someDevice = someRoom.getDevice(j);
                someDevice.turnIt(newState);
            }
        }
    }

    public void switchByRoom(String roomName, boolean newState){
        Room someRoom = myHome.getRoom(roomName);
        System.out.println("\nI'm on room --> " + someRoom.getName());
        int deviceCount = someRoom.deviceCount();
        System.out.println("Ooh there are " + deviceCount + " devices in here!");
        for (int j = 0; j < deviceCount ; j++) {
            Device someDevice = someRoom.getDevice(j);
            someDevice.turnIt(newState);
        }
    }

    public void switchByDevice(String deviceName, boolean newState){
        int roomCount = myHome.roomCount();
        System.out.println("\nThere are " + roomCount + " rooms in this House!");
        //lets traverse all rooms
        for (int i = 0; i < roomCount; i++) {
            Room someRoom = myHome.getRoom(i);

            System.out.println("\nI'm on room --> " + someRoom.getName());
            int deviceCount = someRoom.deviceCount();
            for (int j = 0; j < deviceCount ; j++) {
                Device someDevice = someRoom.getDevice(j);
                if(someDevice.getName() == deviceName){
                    System.out.println("Found the " + someDevice.getName() + "!");
                    someDevice.turnIt(newState);
                    return;
                }
                else{
                    System.out.println("Hmm the " + deviceName + " is not here, moving on...");
                }
            }
        }
    }

}
