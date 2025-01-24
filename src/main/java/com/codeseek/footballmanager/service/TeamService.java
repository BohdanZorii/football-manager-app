package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.team.TeamRequestDto;
import com.codeseek.footballmanager.dto.team.TeamResponseDto;
import com.codeseek.footballmanager.model.Team;
import java.util.List;
import java.util.UUID;

public interface TeamService {
    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto getTeamById(UUID id);

    List<TeamResponseDto> getAllTeams();

    TeamResponseDto updateTeam(UUID id, TeamRequestDto teamRequestDto);

    void deleteTeam(UUID id);

    Team findById(UUID id);

    boolean existsById(UUID id);
}
