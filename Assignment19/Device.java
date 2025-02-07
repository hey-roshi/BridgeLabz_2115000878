public class Device{
    int deviceId;
    String status;
    public Device(int deviceId, String status){
        this.deviceId=deviceId;
        this.status=status;
    }
    public void displayStatus(){
        System.out.println("Device id is: "+deviceId);
        System.out.println("Device status is: "+status);
    }
    public static void main(String args[]){
        Device obj1=new Device(01,"Ready");
        obj1.displayStatus();
        Device obj2=new Thermostat(02,"Not ready", "high");
        obj2.displayStatus();
    }
}
class Thermostat extends Device{
    String tempSettings;
    public Thermostat(int deviceId, String status, String tempSettings){
        super(deviceId,status);
        this.tempSettings=tempSettings;
    }
    public void displayStatus(){
        System.out.println("Device id is: "+deviceId);
        System.out.println("Device status is: "+status);
        System.out.println("Device tempearture setting is: "+tempSettings);
    }


}
