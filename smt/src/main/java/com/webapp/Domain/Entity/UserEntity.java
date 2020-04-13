package com.webapp.Domain.Entity;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long seq;

    @Column
    private String userName;

    @Column
    private String userId;

    @Column
    private String password;


    @Builder
    public UserEntity(Long seq, String userName, String userId, String password){
        this.seq = seq;
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }
}