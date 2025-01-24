package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.transfer.TransferRequestDto;
import com.codeseek.footballmanager.dto.transfer.TransferResponseDto;
import java.util.List;
import java.util.UUID;

public interface TransferService {
    TransferResponseDto createTransfer(TransferRequestDto dto);

    List<TransferResponseDto> getAllTransfers();

    TransferResponseDto getTransferById(UUID transferId);

    void deleteTransfer(UUID transferId);
}
