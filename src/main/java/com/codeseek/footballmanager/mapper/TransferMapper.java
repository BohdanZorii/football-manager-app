package com.codeseek.footballmanager.mapper;

import com.codeseek.footballmanager.dto.transfer.TransferRequestDto;
import com.codeseek.footballmanager.dto.transfer.TransferResponseDto;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.model.Transfer;
import java.math.BigDecimal;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    @Mapping(target = "playerId", source = "player.id")
    @Mapping(target = "fromTeamId", source = "fromTeam.id")
    @Mapping(target = "toTeamId", source = "toTeam.id")
    TransferResponseDto toResponseDto(Transfer transfer);

    List<TransferResponseDto> toResponseDtoList(List<Transfer> teams);

    @Mapping(target = "id", ignore = true)
    Transfer toEntity(TransferRequestDto dto, Player player, Team fromTeam, Team toTeam,
        BigDecimal transferAmount, BigDecimal commission);
}
