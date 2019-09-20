package Devices;

public class Microwave extends Device {
    public Microwave(){
        super();
    }

    public Microwave(String name){
        super(name);
    }

    public void turnIt(boolean on){
        super.turnIt(on);
        if(on)
            System.out.println("\t\tHeating up that tasty food! Nom Nom Nom...");
        else
            System.out.println("\t\tMicrowave is off! Bon Appetite!");
    }
}
