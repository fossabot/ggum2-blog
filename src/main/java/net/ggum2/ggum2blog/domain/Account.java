package net.ggum2.ggum2blog.domain;

import lombok.*;
import net.ggum2.ggum2blog.domain.enums.Role;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Account implements Serializable{

    @NonNull
    private String id;

    private String password;

    private String name;

    private String nickname;

    private boolean enable;

    private Role role;

}
