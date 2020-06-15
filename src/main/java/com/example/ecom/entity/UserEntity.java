package com.example.ecom.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the users database table.
 */
@Immutable
@Setter
@Getter
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String email;
    private String name;
    private List<BookmarkEntity> books;
}