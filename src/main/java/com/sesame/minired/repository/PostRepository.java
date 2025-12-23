package com.sesame.minired.repository;

import com.sesame.minired.entities.Community;
import com.sesame.minired.entities.Post;
import com.sesame.minired.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCommunity(Community community);

    List<Post> findByAuthor(User author);
}
