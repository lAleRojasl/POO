package Devices;

public class TV extends Device {
    //TV's specific attributes
    private int channel;

    public TV(){
        super();
        this.channel = 1;
    }

    public TV(String name){
        super(name);
        this.channel = 1;
    }

    //TV's specific methods
    public void setChannel(int newChannel){
        this.channel = newChannel;
    }

    public int getChannel(){
        return this.channel;
    }

}
