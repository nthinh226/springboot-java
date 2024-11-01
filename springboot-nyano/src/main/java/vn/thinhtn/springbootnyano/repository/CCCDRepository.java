package vn.thinhtn.springbootnyano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.thinhtn.springbootnyano.entity.user.CCCDEntity;

public interface CCCDRepository extends JpaRepository<CCCDEntity, Long> {
}
