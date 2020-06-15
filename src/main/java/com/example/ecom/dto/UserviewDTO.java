package com.example.ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


/**
 * The persistent class for the userview database table.
 */
@Setter
@Getter
public class UserviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private UserDTO userDTO;
}