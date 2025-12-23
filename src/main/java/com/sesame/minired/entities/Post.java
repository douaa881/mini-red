package com.sesame.minired.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Community FK
    @ManyToOne
    @JoinColumn(name = "community_id", nullable = false)
    private Community community;

    // Author FK
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String imageUrl;

    private LocalDate dateCreated;

    @OneToMany(mappedBy = "post")
    private List<Interaction> interactions;

    @OneToMany(mappedBy = "post")
    private List<Report> reports;

    // Getters and setters
}
