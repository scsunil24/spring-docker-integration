package io.sunilbranch.springdockerintegration.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "player", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})

public class Player {

    //id,first_name,last_name,email,gender,ip_address,avatar

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255")
    @NotEmpty(message = "First Name cannot be empty")
    private String first_name;

    @Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255")
    @NotEmpty(message = "Last Name cannot be empty")
    private String last_name;

    @Email
    @NotEmpty(message = "Email ID must not be empty")
    private String email;

    @NotEmpty(message = "Gender cannot be null")
    private String gender;

    @NotEmpty(message = "ip address cannot be null")
    private String ip_address;

    @NotEmpty(message = "avatar cannot be null")
    private String avatar;

    public Player() {
    }


    public Player(Integer id, @Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255") @NotEmpty(message = "First Name cannot be empty") String first_name, @Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255") @NotEmpty(message = "Last Name cannot be empty") String last_name, @Email @NotEmpty(message = "Email ID must not be empty") String email, @NotEmpty(message = "Gender cannot be null") String gender, @NotEmpty(message = "ip address cannot be null") String ip_address, @NotEmpty(message = "avatar cannot be null") String avatar) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
        this.avatar = avatar;
    }

    public Player(@Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255") @NotEmpty(message = "First Name cannot be empty") String first_name, @Size(min = 3, max = 255, message = "Size must be in the given range of min - 3 and max - 255") @NotEmpty(message = "Last Name cannot be empty") String last_name, @Email @NotEmpty(message = "Email ID must not be empty") String email, @NotEmpty(message = "Gender cannot be null") String gender, @NotEmpty(message = "ip address cannot be null") String ip_address, @NotEmpty(message = "avatar cannot be null") String avatar) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", ip_address='" + ip_address + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
