package com.codeseek.footballmanager.mapper;

import com.codeseek.footballmanager.dto.player.PlayerRequestDto;
import com.codeseek.footballmanager.dto.player.PlayerResponseDto;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    Player toEntity(PlayerRequestDto dto, Team team);

    @Mapping(target = "teamName", source = "team.name")
    PlayerResponseDto toResponseDto(Player player);

    List<PlayerResponseDto> toResponseDtoList(List<Player> players);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    void updatePlayerFromDto(PlayerRequestDto dto, Team team, @MappingTarget Player player);
}
