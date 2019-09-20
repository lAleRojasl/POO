package Devices;

public abstract class Device {
    private String name;
    private boolean isOn;

    protected Device(){
        this.isOn = false;
    }

    protected Device(String name){
        this.name = name;
        this.isOn = false;
    }

    public void turnIt(boolean on) {
        if (on) {
            System.out.println("\t\tSwitching ON device --> " + this.name);
            this.isOn = true;
        } else {
            System.out.println("\t\tSwitching OFF device --> " + this.name);
            this.isOn = false;
        }
    }

    public final String getName(){
        return this.name;
    }

    public final boolean isOn(){
        return this.isOn;
    }
}
