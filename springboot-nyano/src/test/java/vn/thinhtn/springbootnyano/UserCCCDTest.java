package vn.thinhtn.springbootnyano;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import vn.thinhtn.springbootnyano.entity.user.CCCDEntity;
import vn.thinhtn.springbootnyano.entity.user.UserEntity;
import vn.thinhtn.springbootnyano.repository.CCCDRepository;
import vn.thinhtn.springbootnyano.repository.UserRepository;

@SpringBootTest
public class UserCCCDTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserName("Tips CCCD");
        user.setUserEmail("cccc01@gmail.com");

        cccd.setNumberCCCD("1112223333");
        user.setCccd(cccd);

        userRepository.save(user);
    }
}
