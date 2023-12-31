
package flightsystem;

public class Passenger{
    String name;
    String passportNum;
    String phoneNumber;
    String email;
    
    public Passenger(String name,String passportNum){
        this.name = name;
        this.passportNum = passportNum;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassportNum(){
        return passportNum;
    }
    public void setPassportNum(String passportNum){
        this.passportNum = passportNum;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    @Override
    public String toString(){
        return "Name: " + name + " , Passport number: " + passportNum;
    }
}
