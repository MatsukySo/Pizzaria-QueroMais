package com.example.demo.DTO;

import com.example.demo.entities.User;

public class UserDTO {
    private String name;
    private String phone;
    private String address;

    public UserDTO(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
