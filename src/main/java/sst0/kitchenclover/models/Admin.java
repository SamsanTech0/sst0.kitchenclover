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
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    
    private long adminId;

    private String adminName;
    
    private String adminPass;


    public long getId() {
        return adminId;
    }

    public void setId(long adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return adminName;
    }

    public void setName(String adminName) {
        this.adminName = adminName;
    }
    public String getPass() {
        return adminPass;
    }

    public void setPass(String adminPass) {
        this.adminPass = adminPass;
    }

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adminName=" + adminName + "]";
    }

}
