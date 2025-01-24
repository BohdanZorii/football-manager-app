package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
