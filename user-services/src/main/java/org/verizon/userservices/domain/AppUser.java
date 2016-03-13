package org.verizon.userservices.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This class is having all the information related to AppUser.
 * 
 * @author Giri
 *
 */
@Entity
@Table(name = "app_user")
public class AppUser implements Serializable {
    private static final long serialVersionUID = -2439937373647669904L;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @Column(name = "original_id", unique = true, nullable = false)
    private String originalUserId;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    // set default value
    @Column(name = "active_ind", nullable = false, length = 1)
    private String activeInd = "A";

    @Column(name = "src_system", nullable = false, length = 1)
    private String srcSystem;

    // set default value
    @Column(name = "is_synced", nullable = false, length = 1)
    private String isSynced = "Y";

    // set default value
    @Column(name = "is_system_acc", nullable = false, length = 1)
    private String isSystemAccount = "N";

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<AppGroup> groups;

    @Column(name = "inherited_user_id", nullable = true)
    private int inheritedUserId;

    /**
     * Default constructor
     * 
     * @author abhishek
     * @since 1.0
     */
    public AppUser() {
        super();
    }

    /**
     * @param userId
     * @param originalUserId
     * @author abhishek
     * @since 1.0
     */
    public AppUser(int userId, String originalUserId) {
        super();
        this.userId = userId;
        this.originalUserId = originalUserId;
    }

    /**
     * @return the userId
     * @since 1.0
     * @see int
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     * @since 1.0
     * @see int
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the originalUserId
     * @since 1.0
     * @see String
     */
    public String getOriginalUserId() {
        return originalUserId;
    }

    /**
     * @param originalUserId
     *            the originalUserId to set
     * @since 1.0
     * @see String
     */
    public void setOriginalUserId(String originalUserId) {
        this.originalUserId = originalUserId;
    }

    /**
     * @return the firstName
     * @since 1.0
     * @see String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     * @since 1.0
     * @see String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     * @since 1.0
     * @see String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     * @since 1.0
     * @see String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailId
     * @since 1.0
     * @see String
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     * @since 1.0
     * @see String
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the activeInd
     * @since 1.0
     * @see String
     */
    public String getActiveInd() {
        return activeInd;
    }

    /**
     * @param activeInd
     *            the activeInd to set
     * @since 1.0
     * @see String
     */
    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    /**
     * @return the srcSystem
     * @since 1.0
     * @see String
     */
    public String getSrcSystem() {
        return srcSystem;
    }

    /**
     * @param srcSystem
     *            the srcSystem to set
     * @since 1.0
     * @see String
     */
    public void setSrcSystem(String srcSystem) {
        this.srcSystem = srcSystem;
    }

    /**
     * @return the isSynced
     * @since 1.0
     * @see String
     */
    public String getIsSynced() {
        return isSynced;
    }

    /**
     * @param isSynced
     *            the isSynced to set
     * @since 1.0
     * @see String
     */
    public void setIsSynced(String isSynced) {
        this.isSynced = isSynced;
    }

    /**
     * @return the isSystemAccount
     * @since 1.0
     * @see String
     */
    public String getIsSystemAccount() {
        return isSystemAccount;
    }

    /**
     * @param isSystemAccount
     *            the isSystemAccount to set
     * @since 1.0
     * @see String
     */
    public void setIsSystemAccount(String isSystemAccount) {
        this.isSystemAccount = isSystemAccount;
    }

    /**
     * @return the groups
     * @since 1.0
     * @see AppGroup
     */
    public Set<AppGroup> getGroups() {
        return groups;
    }

    /**
     * @param groups
     *            the groups to set
     * @since 1.0
     * @see AppGroup
     */
    public void setGroups(Set<AppGroup> groups) {
        this.groups = groups;
    }

    /**
     * @param group
     *            the group to add
     * @author abhishek
     * @since 1.0
     */
    public void addUser(AppGroup group) {
        if (null == this.groups) {
            this.groups = new HashSet<AppGroup>();
        }
        this.groups.add(group);
    }

    /**
     * @param groupNames
     * @author abhishek
     * @since  1.0
     */
    public void removeGroups(String... groupNames) {
        if (null == groupNames || 0 == groupNames.length) {
            return;
        }
        if (null != this.groups) {
            Iterator<AppGroup> iterator = this.groups.iterator();
            while (iterator.hasNext()) {
                AppGroup group = iterator.next();
                for (String groupName : groupNames) {
                    if (groupName.equals(group.getGroupName())) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    /**
     * @return the inheritedUserId
     * @since 1.0
     * @see int
     */
    public int getInheritedUserId() {
        return inheritedUserId;
    }

    /**
     * @param inheritedUserId
     *            the inheritedUserId to set
     * @since 1.0
     * @see int
     */
    public void setInheritedUserId(int inheritedUserId) {
        this.inheritedUserId = inheritedUserId;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AppUser [ " + originalUserId + " ( " + inheritedUserId + " ) : " + activeInd + " ]";
    }
}
