package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Transfer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    @EntityGraph(attributePaths = {"player", "fromTeam", "toTeam"})
    List<Transfer> findAll();

    @EntityGraph(attributePaths = {"player", "fromTeam", "toTeam"})
    Optional<Transfer> findById(UUID id);
}
