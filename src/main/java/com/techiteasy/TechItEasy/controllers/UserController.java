package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.dtos.RoleInputDto;
import com.techiteasy.TechItEasy.dtos.UserDto;
import com.techiteasy.TechItEasy.exceptions.BadRequestException;
import com.techiteasy.TechItEasy.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
//       Bonusopdracht
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = authentication.getName();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin && !loggedInUsername.equals(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        UserDto optionalUser = userService.getUser(username);

        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping
    public ResponseEntity<UserDto> createKlant(@RequestBody UserDto dto) {
        ;

        String newUsername = userService.createUser(dto);
        userService.addRole(newUsername, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateKlant(@PathVariable("username") String username, @RequestBody UserDto dto) {

        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteKlant(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/roles")
    public ResponseEntity<Object> getUserRoles(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getRoles(username));
    }

    @PostMapping(value = "/{username}/roles")
    public ResponseEntity<Object> addUserRole(@PathVariable("username") String username, @RequestBody RoleInputDto roleInputDto) {
        try {
            String roleName = roleInputDto.role;
            userService.addRole(username, roleName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/roles/{role}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("role") String role) {
        userService.removeRole(username, role);
        return ResponseEntity.noContent().build();
    }
}
