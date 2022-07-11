package com.smart.project.web.home.vo;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class JoinVO {
    @NonNull
    String id;
    @NonNull
    String pw;

    String name;

    String email;
    String nick;
}
