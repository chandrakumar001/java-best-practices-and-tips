package com.example.ecom.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


/**
 * The persistent class for the userview database table.
 */
@Setter
@Getter
public class UserViewEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private UserEntity userEntity;
}