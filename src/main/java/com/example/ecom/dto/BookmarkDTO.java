package com.example.ecom.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * The persistent class for the bookmarks database table.
 */
@Immutable
@Setter
@Getter
public class BookmarkDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String name;
    @Column(name = "user_id")
    private String userId;
    private String  url;
}