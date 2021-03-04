package sst0.kitchenclover.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Miles
 */
@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    
    private long id;
    private String name;
    private String contact;
    private String guest;
    private LocalDate doe;
    private String delivery;
    private String time;
    private String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getContact(){
        return contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    }
    
    public String getGuest(){
        return guest;
    }
    
    public void setGuest(String guest){
        this.guest = guest;
    }
    
    public LocalDate getDoe() {
        return doe;
    }

    public void setDoe(LocalDate doe) {
        this.doe = doe;
    }
    
    public String getDelivery(){
        return delivery;
    }
    
    public void setDelivery(String delivery){
        this.delivery = delivery;
    }
    
    public String getTime(){
        return time;
    }
    
    public void setTime(String time){
        this.time = time;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    
    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name + "]";
    }

}
