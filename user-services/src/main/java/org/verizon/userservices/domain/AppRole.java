package org.verizon.userservices.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.verizon.userservices.domain.enums.RoleNames;

/**
 * This class encapsulates the Role information for the Application.
 * 
 * Roles define what the user will be allowed to do in the Application.
 * 
 * This however does not limit the user access to any data in the system. Data
 * level access is controlled by the
 * {@link org.verizon.userservices.domain.AppAccess} class.
 * 
 * @author abhishek
 * @since 1.0
 */
@Entity
@Table(name = "app_role", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "user_id",
        "original_user_id",
        "group_id",
        "group_name"
    }, name = "uk_user_group")
})
public class AppRole implements Serializable {
    private static final long serialVersionUID = 7139294266643364776L;

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "original_user_id", nullable = false)
    private String originalUserId;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "role_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleNames roleName;

    @Column(name = "active_ind", nullable = false, length = 1)
    private String activeInd = "A"; // set default value

    /**
     * Default constructor.
     * 
     * @author abhishek
     * @since 1.0
     */
    public AppRole() {
        super();
    }

    /**
     * @param roleId
     * @param userId
     * @param originalUserId
     * @param groupId
     * @param groupName
     * @param roleName
     * @author abhishek
     * @since 1.0
     */
    public AppRole(int userId, String originalUserId, int groupId, String groupName, RoleNames roleName) {
        super();
        this.userId = userId;
        this.originalUserId = originalUserId;
        this.groupId = groupId;
        this.groupName = groupName;
        this.roleName = roleName;
    }

    /**
     * @return the roleId
     * @since 1.0
     * @see int
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     *            the roleId to set
     * @since 1.0
     * @see int
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
        this.groupName = groupName;
    }

    /**
     * @return the roleName
     * @since 1.0
     * @see RoleNames
     */
    public RoleNames getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     * @since 1.0
     * @see RoleNames
     */
    public void setRoleName(RoleNames roleName) {
        this.roleName = roleName;
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
     * @author abhishek
     * @since 1.0
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AppRole [ " + originalUserId + " : " + groupName + " : " + roleName + " ( " + activeInd + " ) ]";
    }
}
