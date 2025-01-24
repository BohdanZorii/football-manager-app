package com.codeseek.footballmanager.repository;

import com.codeseek.footballmanager.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
