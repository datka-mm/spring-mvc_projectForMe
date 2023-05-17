package peaksoft.service;

import peaksoft.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    String updateUserById(Long id, User user);

    void deleteUserById(Long id);

    List<User> searchUser(String word);
}
