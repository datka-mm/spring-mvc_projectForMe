package peaksoft.repository;

import peaksoft.entity.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    String updateUserById(Long id, User user);

    void deleteUserById(Long id);

    List<User> searchUser(String word);

    void assignHouseToUser(Long houseId, Long userId);
}
