package vn.thinhtn.springbootnyano.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import vn.thinhtn.springbootnyano.entity.user.UserEntity;
import vn.thinhtn.springbootnyano.repository.UserRepository;
import vn.thinhtn.springbootnyano.service.UserService;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByUserNameAndUserEmail(String userName, String userEmail) {
        return userRepository.findByUserNameAndUserEmail(userName, userEmail);
    }

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUserName(String name, Pageable pageable) {
        System.out.println(name);
        return userRepository.findByUserNameContaining(name, pageable);
    }
}
