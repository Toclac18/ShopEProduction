package main.ShopEProduction.Common.Service;

import main.ShopEProduction.Common.Entity.User;
import main.ShopEProduction.Common.Error.ErrorHandler;
import main.ShopEProduction.Common.Exception.ExceptionFormat;
import main.ShopEProduction.Common.Repository.UserRepository;
import main.ShopEProduction.Function.User.Create.Request.UserCreationRequest;
import main.ShopEProduction.Function.User.Update.Request.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUserName(request.getUserName()))
            throw new ExceptionFormat(ErrorHandler.USER_ALREADY_EXISTS);

        user.setUserName(request.getUserName());
        user.setPassWord(request.getPassWord());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User updateUser(String id, UserUpdateRequest request) {

        User user = userRepository.getUserById(id);

        user.setUserName(request.getUserName());
        user.setPassWord(request.getPassWord());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
