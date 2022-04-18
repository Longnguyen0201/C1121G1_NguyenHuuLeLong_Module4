package com.codegym.model.employee.user;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Integer roleId;
    private String username;

}
