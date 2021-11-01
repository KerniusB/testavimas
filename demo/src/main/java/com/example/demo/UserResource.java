package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserController userController;

    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addEmployee(@RequestBody User user) {
        User newEmployee = userController.addUser(user);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User user) {
        User updateEmployee = userController.updateUser(user);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        userController.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
