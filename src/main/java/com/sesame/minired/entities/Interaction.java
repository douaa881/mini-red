package com.sesame.minired.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User FK
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Post FK
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Enumerated(EnumType.STRING)
    private InteractionType typeInteraction;

    // Only used when typeInteraction == COMMENT
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDate dateCommented;
}
