package com.sesame.minired.repository;

import com.sesame.minired.entities.Post;
import com.sesame.minired.entities.Report;
import com.sesame.minired.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByPost(Post post);

    List<Report> findByUser(User user);
}
