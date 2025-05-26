package main.ShopEProduction.Function.User.Controller;

import jakarta.validation.Valid;
import main.ShopEProduction.Common.Entity.User;
import main.ShopEProduction.Function.User.Create.Request.UserCreationRequest;
import main.ShopEProduction.Function.User.Update.Request.UserUpdateRequest;
import main.ShopEProduction.Common.Response.ApiResponse;
import main.ShopEProduction.Common.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    ApiResponse<User> getUserById(@PathVariable String userId){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.getUserById(userId));
        return apiResponse;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }

    @PatchMapping("/users/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUser(userId);
    }
}
