package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        Boolean saved = userService.save(user);
        if(saved){
            return ResponseEntity.ok("Success!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
         Boolean deleted = userService.deleted(id);
         if(deleted){
             return ResponseEntity.ok("Success");
         }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user =  userService.findById(id);
        if(user != null) {
            return ResponseEntity.ok(new UserDTO(user));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<String> updateName(@PathVariable Long id,@RequestBody Map<String, String> request){
        String name = request.get("name");
       Boolean update = userService.updateName(id, name);
        if(update){
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody Map<String, String> request){
        String address = request.get("address");
        Boolean update = userService.updateAddress(id, address);
        if(update){
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @PutMapping("/{id}/phone")
    public ResponseEntity<String> updatePhone(@PathVariable Long id, @RequestBody Map<String, String> request){
        String phone = request.get("phone");
        Boolean update = userService.updatePhone(id, phone);
        if(update){
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }
}