package dio.santander_dev_week_2023.service;

import dio.santander_dev_week_2023.domain.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    User create(User user);

    List<User> findAll();
}
