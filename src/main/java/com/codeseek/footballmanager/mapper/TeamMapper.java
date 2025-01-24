package com.codeseek.footballmanager.mapper;

import com.codeseek.footballmanager.dto.team.TeamRequestDto;
import com.codeseek.footballmanager.dto.team.TeamResponseDto;
import com.codeseek.footballmanager.model.Team;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team toEntity(TeamRequestDto dto);

    TeamResponseDto toResponseDto(Team team);

    List<TeamResponseDto> toResponseDtoList(List<Team> teams);

    void updateTeamFromDto(TeamRequestDto teamRequestDto, @MappingTarget Team team);
}
