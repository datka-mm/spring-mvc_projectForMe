package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.House;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public String updateUserById(Long id, User user) {
        User user1 = entityManager.find(User.class, id);
        user1.setUserName(user.getUserName());
        user1.setDescription(user.getDescription());
        user1.setPhoto(user.getPhoto());
        entityManager.merge(user1);
        return "successfully updated!";
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> searchUser(String word) {
        return entityManager.createQuery("select u from User u where u.userName like :word", User.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
    }

    @Override
    public void assignHouseToUser(Long houseId, Long userId) {
        House house = entityManager.find(House.class, houseId);
        User user = entityManager.find(User.class, userId);

    }
}
