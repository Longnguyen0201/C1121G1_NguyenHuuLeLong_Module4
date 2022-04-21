package com.codegym.model.employee.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<UserRole> useRoles;

    public Role() {
    }


    public Set<UserRole> getUseRoles() {
        return useRoles;
    }

    public void setUseRoles(Set<UserRole> useRoles) {
        this.useRoles = useRoles;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
