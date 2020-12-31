package com.dekelbz.animals.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Dog extends Animal {
    boolean dangerous;
}
