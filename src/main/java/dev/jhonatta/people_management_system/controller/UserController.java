package dev.jhonatta.people_management_system.controller;

import dev.jhonatta.people_management_system.dto_mapper.UserDTO;
import dev.jhonatta.people_management_system.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user){
        UserDTO newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully! " + newUser.getName() + "(ID): " + newUser.getId());
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUsers(){
        List<UserDTO> users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listUserById (@PathVariable Long id){
        UserDTO user = userService.listUserById(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with id: " + id +" not found");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUsers(@PathVariable Long id, @RequestBody UserDTO userUpdated){
        UserDTO user = userService.listUserById(id);
        if (user != null){
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(userService.updateUser(id,userUpdated));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with id: " + id + " not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        UserDTO user = userService.listUserById(id);
        if (user != null){
            userService.userDeleteById(id);
            return ResponseEntity.ok("User with id: "+ id +" was deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with id: " + id + " not found");
        }
    }

    //Constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

}
