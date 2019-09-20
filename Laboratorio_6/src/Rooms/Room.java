package Rooms;
import Devices.Device;
import java.util.ArrayList;

public abstract class Room {
    private String name;
    private ArrayList<Device> devices;

    protected Room(){
        //List of Devices on this room
        this.devices = new ArrayList<>();
    }

    protected Room(String name){
        this.devices = new ArrayList<>();
        this.name = name;
    }

    public final int deviceCount(){
        return this.devices.size();
    }

    public final Device getDevice(int deviceIndex){
        return this.devices.get(deviceIndex);
    }

    public final Device getDevice(String deviceName){
        for (Device d:
             devices) {
            if(d.getName() == deviceName){
                return d;
            }
        }
        return null;
    }

    public final void addDevice(Device newDevice){
        this.devices.add(newDevice);
    }

    public final void removeDevice(Device device){
        this.devices.remove(device);
    }

    public final String getName(){
        return this.name;
    }

}
