package dio.santander_dev_week_2023.service.impl;

import dio.santander_dev_week_2023.domain.model.User;
import dio.santander_dev_week_2023.repository.UserRepository;
import dio.santander_dev_week_2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists");
        }
        else {
            return userRepository.save(userToCreate);
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
