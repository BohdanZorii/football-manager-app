package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.transfer.TransferRequestDto;
import com.codeseek.footballmanager.dto.transfer.TransferResponseDto;
import com.codeseek.footballmanager.exception.InsufficientFundsException;
import com.codeseek.footballmanager.mapper.TransferMapper;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.model.Transfer;
import com.codeseek.footballmanager.repository.TransferRepository;
import com.codeseek.footballmanager.service.CalculationService;
import com.codeseek.footballmanager.service.PlayerService;
import com.codeseek.footballmanager.service.TeamService;
import com.codeseek.footballmanager.service.TransferService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final PlayerService playerService;
    private final TeamService teamService;
    private final CalculationService calculationService;
    private final TransferMapper transferMapper;


    @Transactional
    @Override
    public TransferResponseDto createTransfer(TransferRequestDto dto) {
        Player player = playerService.findById(dto.playerId());
        Team fromTeam = player.getTeam();
        Team toTeam = teamService.findById(dto.toTeamId());

        BigDecimal transferAmount = calculationService.calculateTransferAmount(player.getExperienceInMonths(), player.getAge());
        BigDecimal commission = calculationService.calculateCommission(transferAmount, fromTeam.getCommissionRate());
        BigDecimal totalCost = transferAmount.add(commission);

        validateTransfer(player, toTeam, totalCost);

        fromTeam.setBudget(fromTeam.getBudget().add(totalCost));
        toTeam.setBudget(toTeam.getBudget().subtract(totalCost));

        Transfer transfer = transferMapper.toEntity(dto, player, fromTeam, toTeam, transferAmount, commission);
        transferRepository.save(transfer);
        return transferMapper.toResponseDto(transfer);
    }

    @Override
    public List<TransferResponseDto> getAllTransfers() {
        List<Transfer> transfers = transferRepository.findAll();
        return transferMapper.toResponseDtoList(transfers);
    }

    @Override
    public TransferResponseDto getTransferById(UUID id) {
        Transfer transfer = findById(id);
        return transferMapper.toResponseDto(transfer);
    }

    @Override
    public void deleteTransfer(UUID id) {
        transferRepository.deleteById(id);
    }

    private Transfer findById(UUID id) {
        return transferRepository.findById(id).orElseThrow(()
            -> new EntityNotFoundException("Transfer not found by id " + id));
    }

    private void validateTransfer(Player player, Team toTeam, BigDecimal totalCost) {
        Team currentTeam = player.getTeam();
        if (currentTeam.equals(toTeam)) {
            throw new IllegalArgumentException("Cannot transfer player to his own team");
        }

        if (toTeam.getBudget().compareTo(totalCost) < 0) {
            throw new InsufficientFundsException("Insufficient funds in the buying team");
        }
    }
}
