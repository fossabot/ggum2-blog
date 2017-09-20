package net.ggum2.ggum2blog.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class UserEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "name", nullable = false, updatable = false, length = 50)
    private String name;

    @Column(name = "nickname", nullable = false, updatable = true, length = 50, unique = true)
    private String nickname;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "created", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "updated", nullable = false, updatable = true)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Column(name = "password_changed", nullable = false)
    private Date passwordUpdated;

    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled;

    @Column(name = "is_account_non_expired", nullable = false)
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked", nullable = false)
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", nullable = false)
    private boolean isCredentialsNonExpired;

}
