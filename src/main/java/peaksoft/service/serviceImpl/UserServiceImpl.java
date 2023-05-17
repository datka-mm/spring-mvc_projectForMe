package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public String updateUserById(Long id, User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public List<User> searchUser(String word) {
        return userRepository.searchUser(word);
    }
}
