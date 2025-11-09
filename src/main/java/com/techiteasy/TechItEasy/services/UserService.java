package com.techiteasy.TechItEasy.services;

import com.techiteasy.TechItEasy.dtos.UserDto;
import com.techiteasy.TechItEasy.exceptions.UsernameNotFoundException;
import com.techiteasy.TechItEasy.models.Role;
import com.techiteasy.TechItEasy.models.User;
import com.techiteasy.TechItEasy.repositories.UserRepository;
import com.techiteasy.TechItEasy.utils.RandomStringGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto;
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            dto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        userDto.apikey = RandomStringGenerator.generateAlphaNumeric(20);
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.password);
        userRepository.save(user);
    }

    public Set<Role> getRoles(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.roles;
    }

    public void addRole(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addRole(new Role(username, authority));
        userRepository.save(user);
    }

    public void removeRole(String username, String role) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Role roleToRemove = user.getRoles().stream().filter((r) -> r.getRole().equalsIgnoreCase(role)).findAny().get();
        user.removeRole(roleToRemove);
        userRepository.save(user);
    }

    public static UserDto fromUser(User user) {

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.roles = user.getRoles();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.username);
        user.setPassword(encoder.encode(userDto.password));
        user.setEnabled(userDto.enabled);
        user.setApikey(userDto.apikey);
        user.setEmail(userDto.email);

        return user;
    }

}
