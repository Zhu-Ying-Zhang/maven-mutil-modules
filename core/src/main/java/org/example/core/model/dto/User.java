package org.example.core.model.dto;

import lombok.*;

/**
 * @author zhuyingzhang
 */
@Builder
@Data
@ToString
public class User {

    private int id;
    private String name;
    private int age;
}
