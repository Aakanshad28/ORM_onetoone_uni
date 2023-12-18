package onetoone_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", aadharCard="
				+ aadharCard + "]";
	}

	@Id
	private int id;
	private String name;
	private long phone;
	private String address;
	@OneToOne(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REMOVE
	},fetch = FetchType.LAZY)//fetch type should be written on owning side
	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@OneToOne(cascade = CascadeType.REMOVE)//feature provide by hibernate 
//	@OneToOne(cascade = CascadeType.PERSIST)
	//@OneToOne
	private AadharCard aadharCard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AadharCard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}

}
