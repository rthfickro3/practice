package com.webapp.smt.Dto;

import com.webapp.Domain.Entity.UserEntity;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Long seq;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String userName;

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=\\S+$).{8,20}",
            message = "숫자가 적어도 한 개가 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인은 필수 입력 값입니다.")
    private String password_Check;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isPasswordNotEquals(){
        return password.equals(password_Check);
    }

    public UserEntity toEntity(){
        return UserEntity.builder()
                .seq(seq)
                .userName(userName)
                .userId(userId)
                .password(password)
                .build();
    }

    @Builder
    public UserDto(Long seq, String userName, String userId, String password, String password_Check){
        this.seq = seq;
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}
