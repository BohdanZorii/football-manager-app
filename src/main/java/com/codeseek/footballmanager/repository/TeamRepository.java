package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
}
