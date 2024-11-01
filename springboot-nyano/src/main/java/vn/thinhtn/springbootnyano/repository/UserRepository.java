package vn.thinhtn.springbootnyano.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import vn.thinhtn.springbootnyano.entity.user.UserEntity;

import java.util.List;

// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    // use pageable
    Page<UserEntity> findByUserName(String name, Pageable pageable);

    Page<UserEntity> findByUserNameContaining(String user, Pageable pageable);

    // find userName and userEmail
    // findByUserNameAndUserEmail
    // userNameAndUserEmail
    // userNameAnduserEmail
    // where userName = ?1 and userEmail = ?1
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // findByUserName
    // UserName
    // userName
    // where userName = ?1
//    UserEntity findByUserName(String userName);

    /**
     * WHERE userName LIKE ?%
     */
    List<UserEntity> findByUserNameStartingWith(String userEmail);

    /**
     * WHERE userName LIKE %?
     */
    List<UserEntity> findByUserNameEndingWith(String userEmail);

    /**
     * WHERE id < 1
     */
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL Syntax

    /**
     * If want to use RAW, we need implement JpaSpecificationExecutor<UserEntity>
     *
     * @return UserEntity
     * @see JpaSpecificationExecutor<UserEntity>
     */
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntitiesBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntitiesByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /**
     * UPDATE DELETE
     */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    /**
     * Native query
     * get count user use native query
     */
    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();


}
