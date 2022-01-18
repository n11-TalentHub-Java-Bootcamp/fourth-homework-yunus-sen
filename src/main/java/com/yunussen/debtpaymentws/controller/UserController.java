package com.yunussen.debtpaymentws.controller;

import com.sun.istack.NotNull;
import com.yunussen.debtpaymentws.service.UserService;
import com.yunussen.debtpaymentws.shared.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUSer(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "create user for request model.")
    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user){
        return ResponseEntity.ok(userService.save(user));
    }

   /* @PutMapping("/{id}")
    public ResponseEntity<UserDto> getUSer(@PathVariable("id") Long id, @RequestBody UserDto user ){
        return ResponseEntity.ok(userService.update(user));
    }*/

    @Operation(summary = "delete user by id")
    @DeleteMapping ("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") @NotNull Long id){
        userService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
