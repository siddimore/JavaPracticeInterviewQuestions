//import java.awt.*;
//import java.util.*;
//
///**
// * Created by siddimore on 7/28/16.
// */
//
//
//
// class AddressBookClient extends Client implements CreateClient{
//    public AddressBookClient(java.util.Map<String,String> args){
//        this.setOperation(args.get("Opeartion"));
//        this.setClientType(args.get("ClientType"));
//        this.setDevice(args.get("Device"));
//    }
//
//     public Client create(java.util.Map<String,String> args){ //error
//        return new AddressBookClient(args);
//    }
//
//    public String getCommand(){
//        String command = null;
//        switch (this.getOperation()){
//            case String.valueOf(Operation.Add): {this.setCommand("contactGen -c {} -n {} -s{}");}
//            case String.valueOf(Operation.Edit): {this.setCommand("contactGen -m {} -s {}");}
//            case String.valueOf(Operation.Delete): {this.setCommand("contactGen -md {} -s {}");}
//
//        }
//        return this.getCommand();
//    }
//
//    public boolean runCommand(){
//        return this.getDevice().os().asRoot().executeShellCommand_(this.getCommand());
//    }
//
//
//}
//
// class CalendarClient extends Client implements CreateClient{
//
//     public CalendarClient(java.util.Map<String,String> args){
//         this.setOperation(args.get("Opeartion"));
//         this.setClientType(args.get("ClientType"));
//         this.setDevice(args.get("Device"));
//     }
//
//     public Client create(java.util.Map<String,String> args){ //error
//        return new CalendarClient(args);
//    }
//
//
//     public String getCommand(){
//         String command = null;
//         switch (this.getOperation()){
//             case String.valueOf(Operation.Add): {this.setCommand("eventGen -c {} -n {} -s{}");}
//             case String.valueOf(Operation.Edit): {this.setCommand("eventGen -m {} -s {}");}
//             case String.valueOf(Operation.Delete): {this.setCommand("eventGen -md {} -s {}");}
//
//         }
//         return this.getCommand();
//     }
//
//     public boolean runCommand(){
//         return this.getDevice().os().asRoot().executeShellCommand_(this.getCommand());
//     }
//}
//
//class ReminderClient extends  Client implements CreateClient{
//
//    public ReminderClient(java.util.Map<String,String> args){
//        this.setOperation(args.get("Opeartion"));
//        this.setClientType(args.get("ClientType"));
//        this.setDevice(args.get("Device"));
//    }
//
//    public Client create(java.util.Map<String,String> args){ //error
//        return new ReminderClient(args);
//    }
//
//    public String getCommand(){
//        switch (this.getOperation()){
//            case String.valueOf(Operation.Add): {this.setCommand( "reminderGen -c {} -n {} -s{}");}
//            case String.valueOf(Operation.Edit): {this.setCommand("reminderGen -m {} -s {}");}
//            case String.valueOf(Operation.Delete): {this.setCommand("reminderGen -md {} -s {}");}
//
//        }
//        return this.getCommand();
//    }
//
//    public boolean runCommand(){
//        return this.getDevice().os().asRoot().executeShellCommand_(this.getCommand());
//    }
//}
//
//
//
//abstract class Client{
//    private String operation;
//    private String command;
//    private String clientType;
//    private String device;
//
//    public void setCommand(String command) {
//        this.command = command;
//    }
//
//    public String getDevice() {
//        return device;
//    }
//
//    public void setDevice(String device) {
//        this.device = device;
//    }
//
//    public String getClientType() {
//        return clientType;
//    }
//
//    public void setClientType(String clientType) {
//        this.clientType = clientType;
//    }
//
//    public String getOperation() {
//        return operation;
//    }
//
//    public void setOperation(String operation) {
//        this.operation = operation;
//    }
//
//     String getCommand(){
//     System.out.println("Override this with your own method") ;
//         return null;
//     }
//
//    boolean runCommand(){
//        return false;
//    }
//}
//
//public class ClienFactory {
//
//    Map<String, String> args = new HashMap<>();
//
//
//    //use getShape method to get object of type shape
//    public Client getClient(String clientType){
//        if(clientType == null){
//            return null;
//        }
//        if(clientType.equalsIgnoreCase("AddressBookClient")){
//            return new AddressBookClient(args);
//
//        } else if(clientType.equalsIgnoreCase("CalendarClient")){
//            return new CalendarClient(args);
//
//        } else if(clientType.equalsIgnoreCase("ReminderClient")){
//            return new ReminderClient(args);
//        }
//
//        return null;
//    }
//}
