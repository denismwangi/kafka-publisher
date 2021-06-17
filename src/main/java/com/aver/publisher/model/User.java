package com.aver.publisher.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author denis
 * 17/6/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int Id;
    private String name;
    private String address;


}
