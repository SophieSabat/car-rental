package com.petproject.carrental.models.user;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String passport;
    @Column(name = "role_id")
    private int roleID;
    @Column(name = "is_enable")
    private boolean isEnable;

    public User(String login, String password, String email, String firstName, String lastName, String passport, int roleID, boolean isEnable) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.roleID = roleID;
        this.isEnable = isEnable;
    }
}
