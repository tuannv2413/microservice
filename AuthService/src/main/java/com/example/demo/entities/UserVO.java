package com.example.demo.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserVO {
	private String id;
    private String email;
    private String password;
    private String role;
}
