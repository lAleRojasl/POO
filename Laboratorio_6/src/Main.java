import Devices.*;
import Rooms.*;

import javax.naming.ldap.Control;

public class Main {
    public static void main(String[] args) {
        //Initialize Rooms
        Kitchen kitchen = new Kitchen("Kitchen");
        Bedroom aleBedroom = new Bedroom("Ale's Bedroom");
        Bedroom karlaBedroom = new Bedroom("Karla's Bedroom");

        //Initialize Devices
        TV tv = new TV("Samsung Smart TV");
        TV tv2 = new TV("LG 3D");
        Lamp lavaLamp = new Lamp("Ale's Lava Lamp");
        Lamp simpleLamp = new Lamp("Karla's Boring Lamp");
        Microwave micro = new Microwave("Mega Microwave");

        //Place our cool devices
        aleBedroom.addDevice(tv);
        aleBedroom.addDevice(lavaLamp);

        karlaBedroom.addDevice(tv2);
        karlaBedroom.addDevice(simpleLamp);

        kitchen.addDevice(micro);

        //Build our cozy home
        Home rojasHome = new Home("Roja's House");
        rojasHome.addRoom(aleBedroom);
        rojasHome.addRoom(kitchen);
        rojasHome.addRoom(karlaBedroom);

        //Set up the Controller for this House
        Controller rojasHomeCtl = new Controller(rojasHome);

        //Lets turn everything ON
        rojasHomeCtl.switchEverything(true);

        //Lets turn everything OFF on Ale's Bedroom
        rojasHomeCtl.switchByRoom("Ale's Bedroom", false);

        //Lets turn OFF ONLY the Kitchen's Microwave
        rojasHomeCtl.switchByDevice("Mega Microwave", false);
    }
}
