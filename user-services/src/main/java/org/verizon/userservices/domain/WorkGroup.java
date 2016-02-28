package org.verizon.userservices.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class is having all the information related to the workgroup's;
 * @author Giri
 *
 */
@Entity
@Table (name = "work_group")
public class WorkGroup implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String wkgrpName;
	
	@Column(nullable = false)
	private String wkgrpDesc;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "workGroup")
	private Set<User> user;
	
	
	public String getWkgrpName() {
		return wkgrpName;
	}
	public void setWkgrpName(String wkgrpName) {
		this.wkgrpName = wkgrpName;
	}
	
	public String getWkgrpDesc() {
		return wkgrpDesc;
	}
	public void setWkgrpDesc(String wkgrpDesc) {
		this.wkgrpDesc = wkgrpDesc;
	}
	
	@Override
	public String toString() {
		return "WorkGroup [wkgrpId=" + id + ", wkgrpName=" + wkgrpName + ", wkgrpDesc=" + wkgrpDesc + "]";
	}
}
