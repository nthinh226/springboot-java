package vn.thinhtn.springbootnyano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.thinhtn.springbootnyano.entity.feed.FeedEntity;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
