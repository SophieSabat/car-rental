package com.petproject.carrental.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "roles")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "is_enable")
    private boolean isEnable;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public User(String password, String email, String firstName, String lastName, String phoneNumber, String passportNumber) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
    }
}
