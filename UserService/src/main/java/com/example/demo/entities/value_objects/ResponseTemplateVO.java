package com.example.demo.entities.value_objects;

import com.example.demo.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseTemplateVO {
	private User user;
    private Department department;
}
