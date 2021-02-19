package sst0.kitchenclover.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "login")
public class login {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	private int contact_num;
	
	private int room_num;
	
	private int  price;
        
          enum payment_status{
              PAID, DOWNPAYMENT_FULFILLED, UNPAID;
          }
          
          private LocalDate date;
	
	//private String gender;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getContactNum() {
		return contact_num;
	}

	public void setContactNum(int contact_num) {
		this.contact_num = contact_num;
	}
          
          public int getRoomNum() {
		return room_num;
	}

	public void setRoomNum(int room_num) {
		this.room_num = room_num;
	}
          
//          public String getPaymentStatus() {
//		return payment_status;
//	}

//	public void setPaymentStatus(String paymentStatus) {
//		this.paymentStatus = paymentStatus;
//	}
          
          public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	public class getPaymentStatus() {
//		
//	}
//
//	public void setPaymentStatus(String lastName) {
//		this.lastName = lastName;
//	}
	
	public LocalDate getDate() {
		return date;
	}
          
          public void setDate(LocalDate date) {
		this.date = date;
	}

	
        
        
	
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
	

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", contact_num=" + contact_num + ", room_num=" + room_num + ", price=" + price +/* ", payment_status="+ //payment_status+*/ "]";
	}





	
}

