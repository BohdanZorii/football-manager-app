package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Player;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
    @EntityGraph(attributePaths = "team")
    List<Player> findAll();

    @EntityGraph(attributePaths = "team")
    Optional<Player> findById(UUID id);
}
