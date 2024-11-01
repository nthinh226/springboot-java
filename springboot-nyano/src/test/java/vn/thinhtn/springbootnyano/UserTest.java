package vn.thinhtn.springbootnyano;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import vn.thinhtn.springbootnyano.entity.feed.FeedEntity;
import vn.thinhtn.springbootnyano.entity.user.UserEntity;
import vn.thinhtn.springbootnyano.repository.FeedRepository;
import vn.thinhtn.springbootnyano.repository.UserRepository;
import vn.thinhtn.springbootnyano.service.UserService;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest() {
        // 1. New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Tips Java");
        user.setUserEmail("tipsjava@gmail.com");

        feed.setTitle("feed 001");
        feed.setDescription("This is a description");
        feed.setUser(user);

        userRepository.save(user);
        feedRepository.save(feed);
    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTestTwo() {
        // 1. New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Tips Go");
        user.setUserEmail("go1@gmail.com");

        feed.setTitle("feed 003");
        feed.setDescription("This is a description");
        user.setFeedList(List.of(feed));
        feed.setUser(user);

        userRepository.save(user);
//        feedRepository.save(feed);
    }

    @Test
    @Transactional
    void selectOneToManyTest() {
        UserEntity user = userRepository.findById(3L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }
}
