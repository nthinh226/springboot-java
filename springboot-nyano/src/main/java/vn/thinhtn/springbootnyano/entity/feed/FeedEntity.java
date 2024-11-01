package vn.thinhtn.springbootnyano.entity.feed;

import jakarta.persistence.*;
import lombok.Data;
import vn.thinhtn.springbootnyano.entity.user.UserEntity;

@Data
@Entity
@Table(name = "java_feed_001")
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob // ánh xạ văn bản dài
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false) // foreign key
    private UserEntity user;
}
