package com.sesame.minired.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String name;

    private String promo;

    private String bio;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Posts authored by this user
    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    // Reports made by this user
    @OneToMany(mappedBy = "user")
    private List<Report> reports;

    // Interactions (votes/comments) by this user
    @OneToMany(mappedBy = "user")
    private List<Interaction> interactions;

    // Communities where the user is admin
    @OneToMany(mappedBy = "admin")
    private List<Community> adminCommunities;
}
