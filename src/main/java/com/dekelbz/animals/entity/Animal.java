package com.dekelbz.animals.entity;

import com.dekelbz.animals.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.MINIMAL_CLASS,
        property = "@class")
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Animal {
    private Long id;
    private String sound;
    private int age;
    private Gender gender;
}
