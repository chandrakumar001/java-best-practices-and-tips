package com.example.ecom.dto;

import com.example.ecom.entity.BookmarkEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the users database table.
 */
@Setter
@Getter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String email;
    private String name;
    private List<BookmarkDTO> books;
}