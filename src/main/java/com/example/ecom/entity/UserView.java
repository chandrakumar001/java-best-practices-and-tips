package com.example.ecom.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;


/**
 * The persistent class for the userview database table.
 */
@Entity
@Setter
@Getter
@Table(name = "userviewtest", schema = "partcv")
@Immutable
public class UserView implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "part_id")
    private UUID partId;

    @Column(name = "test")
    private String test;
}