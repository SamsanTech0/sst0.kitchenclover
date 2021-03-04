package sst0.kitchenclover.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Miles
 */
@Entity
@Table(name = "catering")
public class Catering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)

    private long id;
    private String name;
    private String contact;
    private String time;
    private String location;
    private LocalDate doe;
     private String deliver;
    
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String Location) {
        this.location = Location;
    }
    
    public LocalDate getDoe() {
        return doe;
    }

    public void setDoe(LocalDate doe) {
        this.doe = doe;
    }

    public String getDeliver(){
        return deliver;
    }
    
    public void setDeliver(String deliver){
        this.deliver = deliver;
    }
    
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + " ]";
    }

}
