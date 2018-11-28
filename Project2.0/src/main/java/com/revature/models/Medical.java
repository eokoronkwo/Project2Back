package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Medical_id")
public class Medical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bloodType;
	private boolean organDonor;
	private int heightFeet;
	private int heightInches;
	private float weight;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public boolean isOrganDonor() {
		return organDonor;
	}
	public void setOrganDonor(boolean organDonor) {
		this.organDonor = organDonor;
	}
	public int getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}
	public int getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloodType == null) ? 0 : bloodType.hashCode());
		result = prime * result + heightFeet;
		result = prime * result + heightInches;
		result = prime * result + id;
		result = prime * result + (organDonor ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medical other = (Medical) obj;
		if (bloodType == null) {
			if (other.bloodType != null)
				return false;
		} else if (!bloodType.equals(other.bloodType))
			return false;
		if (heightFeet != other.heightFeet)
			return false;
		if (heightInches != other.heightInches)
			return false;
		if (id != other.id)
			return false;
		if (organDonor != other.organDonor)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Medical [id=" + id + ", bloodType=" + bloodType + ", organDonor=" + organDonor + ", heightFeet="
				+ heightFeet + ", heightInches=" + heightInches + ", weight=" + weight + ", user=" + user + "]";
	}
	public Medical(int id, String bloodType, boolean organDonor, int heightFeet, int heightInches, float weight,
			User user) {
		super();
		this.id = id;
		this.bloodType = bloodType;
		this.organDonor = organDonor;
		this.heightFeet = heightFeet;
		this.heightInches = heightInches;
		this.weight = weight;
		this.user = user;
	}
	public Medical() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
