package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.transfer.TransferRequestDto;
import com.codeseek.footballmanager.dto.transfer.TransferResponseDto;
import com.codeseek.footballmanager.service.TransferService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
@Validated
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponseDto> createTransfer(
        @RequestBody @Valid TransferRequestDto dto) {
        TransferResponseDto createdTransfer = transferService.createTransfer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransfer);
    }

    @GetMapping
    public ResponseEntity<List<TransferResponseDto>> getAllTransfers() {
        List<TransferResponseDto> transfers = transferService.getAllTransfers();
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponseDto> getTransferById(@PathVariable UUID id) {
        TransferResponseDto transfer = transferService.getTransferById(id);
        return ResponseEntity.ok(transfer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransfer(@PathVariable UUID id) {
        transferService.deleteTransfer(id);
        return ResponseEntity.noContent().build();
    }
}