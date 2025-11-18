package com.mars.microservice.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable {
    private static final long seriaVersionUID = 1L;

    private UUID userId;
    private String name;
    private String email;

}
