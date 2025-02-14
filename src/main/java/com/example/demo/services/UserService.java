package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Boolean save(User user){
        userRepository.save(user);
        return true;
    }

    public Boolean deleted(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Boolean updateName(Long id, String name){
        User user = userRepository.findById(id).orElse(null);
         if(user != null){
             user.setName(name);
             userRepository.save(user);
             return true;
         }
         return false;
    }

    public Boolean updateAddress(Long id, String address){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setAddress(address);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Boolean updatePhone(Long id, String phone){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setPhone(phone);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}