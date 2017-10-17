package net.ggum2.ggum2blog.repository.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@ToString
public class UserEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 100)
    private String id;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "name", nullable = false, updatable = false, length = 50)
    private String name;

    @Column(name = "nickname", nullable = false, updatable = true, length = 50, unique = true)
    private String nickname;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "is_enabled", nullable = false)
    private boolean enabled;
}
