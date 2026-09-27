package com.user.userdetails.controller;


import com.user.userdetails.clients.RinkuClient;
import com.user.userdetails.dto.MemberDto;
import com.user.userdetails.entities.User;
import com.user.userdetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    UserRepository repo;
    @Autowired
    RinkuClient rinkuClient;



    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id ) {
        Optional<User> optionalUser = repo.findById(id);
        User user = optionalUser.get();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
       User saveuser = repo.save(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(saveuser);
    }

    @GetMapping("/getGangstersViaUserService/{id}")
    public ResponseEntity<MemberDto> getGangstersViaUserService(@PathVariable int id){
        MemberDto response = rinkuClient.getMemberFromRinkuService(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

}
