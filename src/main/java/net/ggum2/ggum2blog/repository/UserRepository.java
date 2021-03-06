package net.ggum2.ggum2blog.repository;

import net.ggum2.ggum2blog.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hyunsoo0813 on 2017. 9. 11..
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findById(String id);
}
