package net.ggum2.ggum2blog.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ggum2.ggum2blog.model.enums.Role;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by hyunsoo0813 on 2017. 9. 11..
 */
@Entity
@Data
public class UserEntity {

    @Id
    private String username;

    private String password;

    private String name;

    private Role role;

    private boolean isEnabled;

    private Date created;

}
