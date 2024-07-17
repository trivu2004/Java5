package com.example.BaoVeASM.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class account {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;
    private boolean activated;
    private boolean admin;

    // Adjusted toString() method
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", activated=" + activated +
                ", admin=" + admin +
                '}';
    }

    public account(String username, String password, String fullname, String email, String photo, boolean activated, boolean admin) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.photo = photo;
        this.activated = activated;
        this.admin = admin;
    }
}
