package org.verizon.userservices.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This class is having all the information related to the workgroup's;
 * 
 * @author Giri
 *
 */
@Entity
@Table(name = "app_group")
public class AppGroup implements Serializable {
    private static final long serialVersionUID = 5261309970629813260L;

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name", nullable = false, unique = true)
    private String groupName;

    @Column(name = "group_desc", nullable = false)
    private String groupDesc;

    @Column(name = "active_ind", nullable = false, length = 1)
    private String activeInd = "A"; // set default value

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "app_user_group", joinColumns = {
        @JoinColumn(name = "group_id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
        @JoinColumn(name = "user_id", nullable = false, updatable = false)
    })
    private Set<AppUser> users;

    @Column(name = "inherited_group_id", nullable = true)
    private int inheritedGroupId;

    /**
     * Default constructor.
     * 
     * @author abhishek
     * @since 1.0
     */
    public AppGroup() {
        super();
    }

    /**
     * @param groupId
     * @param groupName
     * @param groupDesc
     * @author abhishek
     * @since 1.0
     */
    public AppGroup(int groupId, String groupName, String groupDesc) {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    /**
     * @return the groupId
     * @since 1.0
     * @see int
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *            the groupId to set
     * @since 1.0
     * @see int
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the groupName
     * @since 1.0
     * @see String
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     *            the groupName to set
     * @since 1.0
     * @see String
     */
    public void setGroupName(String groupName) {
        if (null != groupName) {
            this.groupName = groupName.toUpperCase().trim();
        }
        this.groupName = groupName;
    }

    /**
     * @return the groupDesc
     * @since 1.0
     * @see String
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * @param groupDesc
     *            the groupDesc to set
     * @since 1.0
     * @see String
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
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
     * @return the users
     * @since 1.0
     * @see Set<AppUser>
     */
    public Set<AppUser> getUsers() {
        return users;
    }

    /**
     * @param users
     *            the users to set
     * @since 1.0
     * @see Set<AppUser>
     */
    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

    /**
     * @param user
     *            the user to add
     * @author abhishek
     * @since 1.0
     */
    public void addUser(AppUser user) {
        if (null == this.users) {
            this.users = new HashSet<AppUser>();
        }
        this.users.add(user);
    }

    /**
     * @param originalUserIds
     * @author abhishek
     * @since 1.0
     */
    public void removeUsers(String... originalUserIds) {
        if (null == originalUserIds || 0 == originalUserIds.length) {
            return;
        }
        if (null != this.users) {
            Iterator<AppUser> iterator = this.users.iterator();
            while (iterator.hasNext()) {
                AppUser user = iterator.next();
                for (String originalUserId : originalUserIds) {
                    if (originalUserId.equals(user.getOriginalUserId())) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    /**
     * @return the inheritedGroupId
     * @since 1.0
     * @see int
     */
    public int getInheritedGroupId() {
        return inheritedGroupId;
    }

    /**
     * @param inheritedGroupId
     *            the inheritedGroupId to set
     * @since 1.0
     * @see int
     */
    public void setInheritedGroupId(int inheritedGroupId) {
        this.inheritedGroupId = inheritedGroupId;
    }

    /**
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AppGroup [ " + groupName + " ( " + inheritedGroupId
                + " ) | " + activeInd + " | users " + (null != users ? users.size() : 0) + " ]";
    }
}
