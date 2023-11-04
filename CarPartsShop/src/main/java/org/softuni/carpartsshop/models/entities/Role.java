package org.softuni.carpartsshop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @NotNull
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleNamesEnum roleName;

    public Role() {

    }

    public RoleNamesEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleNamesEnum roleName) {
        this.roleName = roleName;
    }

}
