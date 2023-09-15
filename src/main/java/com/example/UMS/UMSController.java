package com.example.UMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UMSController {
    @Autowired
    List<UserManagementSystem> usersList;
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserManagementSystem user) {
        for(UserManagementSystem usr : usersList){
            if(user.getUserId().equals(usr.getUserId())) return "user already exists";
        }
        usersList.add(user);
        return "user added";
    }
    @GetMapping("/getUser/{userid}")
    public UserManagementSystem getUser(@PathVariable Integer userid){
        UserManagementSystem usr = null;
        for(UserManagementSystem user : usersList){
            if(user.getUserId().equals(userid)){
                usr = user;
                break;
            }
        }
        return usr;
    }
    @GetMapping("/getAllUsers")
    public List<UserManagementSystem> getAllUsers(){
        return usersList;
    }
    @PutMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam Integer userId,@RequestParam String name,@RequestParam String userName,@RequestParam String address,@RequestParam Long phoneNumber){
        if(usersList.size() == 0) return "user not found";
        for(UserManagementSystem usr : usersList){
            if(usr.getUserId().equals(userId)){
                usr.setName(name);
                usr.setUserName(userName);
                usr.setAddress(address);
                usr.setPhoneNumber(phoneNumber);
                return "user info updated";
            }
        }
        return "cannot update user info";
    }
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer userId){
        for(UserManagementSystem user : usersList){
            if(user.getUserId().equals(userId)){
                usersList.remove(user);
                return "user deleted";
            }
        }
        return "user not found";
    }
}
