package com.techiteasy.TechItEasy.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techiteasy.TechItEasy.models.Role;

import java.util.Set;


public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;

    @JsonSerialize
    public Set<Role> roles;
}
