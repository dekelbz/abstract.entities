package com.dekelbz.animals.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Cat extends Animal{
    private int color;
    private int beauty;
}
