package vn.thinhtn.springbootnyano.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import vn.thinhtn.springbootnyano.entity.feed.FeedEntity;

import java.util.List;

@Data
@Entity
@Table(name = "java_user_001")
@DynamicInsert // thuộc về hibernate -> bỏ qua các cột có giá trị null
@DynamicUpdate // DynamicInsert/Update giúp tối ưu hoá quá trình insert và update
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // giá trị cần được kiểm sót ID -> tạo ra bảng quản lý ID
    private Long id; // userId

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FeedEntity> feedList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccc_id")
    private CCCDEntity cccd;
}
