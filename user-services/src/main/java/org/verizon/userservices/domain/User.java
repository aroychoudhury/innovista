package org.verizon.userservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * This class is having all the information related to User.
 * 
 * @author Giri
 *
 */
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "userId"), })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int userId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private int garmLevel;

	@Column(nullable = false)
	private String emailId;

	@Column(nullable = false)
	private String userActive;

	@ManyToOne(optional = false)
	@JoinColumn(name = "workgroup_id", nullable = true)
	private WorkGroup workGroup;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGarmLevel() {
		return garmLevel;
	}

	public void setGarmLevel(int garmLevel) {
		this.garmLevel = garmLevel;
	}

	@Override
	public String toString() {
		return getFirstName() + "," + getLastName() + "," + getGarmLevel();
	}
}
