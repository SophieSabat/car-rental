package com.petproject.carrental.models.user;

import com.sun.tools.javac.util.List;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"users"})
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;
    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Collection<User> users, Collection<Privilege> privileges) {
        this.name = name;
        this.users = users;
        this.privileges = privileges;
    }
}
