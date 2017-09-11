package net.ggum2.ggum2blog.repository;

import net.ggum2.ggum2blog.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hyunsoo0813 on 2017. 9. 11..
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
