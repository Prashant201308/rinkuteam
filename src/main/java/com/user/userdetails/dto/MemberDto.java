package com.user.userdetails.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//sets getters and setters
@Data
@NoArgsConstructor
public class MemberDto {

    int id;
    String name;
    int age;

    public MemberDto(int id, String name, int age) {
        this.id =id;
        this.name = name;
        this.age = age;
    }
}
