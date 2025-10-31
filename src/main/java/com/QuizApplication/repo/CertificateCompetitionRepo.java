package com.QuizApplication.repo;

import com.QuizApplication.entities.CertificateCompetition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateCompetitionRepo extends JpaRepository<CertificateCompetition,Integer> {

}
