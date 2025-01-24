package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.team.TeamRequestDto;
import com.codeseek.footballmanager.dto.team.TeamResponseDto;
import com.codeseek.footballmanager.mapper.TeamMapper;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.repository.TeamRepository;
import com.codeseek.footballmanager.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        Team team = teamMapper.toEntity(teamRequestDto);
        teamRepository.save(team);
        return teamMapper.toResponseDto(team);
    }

    @Override
    public TeamResponseDto getTeamById(UUID id) {
        Team team = findById(id);

        return teamMapper.toResponseDto(team);
    }

    @Override
    public List<TeamResponseDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teamMapper.toResponseDtoList(teams);
    }

    @Override
    public TeamResponseDto updateTeam(UUID id, TeamRequestDto teamRequestDto) {
        Team team = findById(id);

        teamMapper.updateTeamFromDto(teamRequestDto, team);
        teamRepository.save(team);
        return teamMapper.toResponseDto(team);
    }

    @Override
    public void deleteTeam(UUID id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team findById(UUID id) {
        return teamRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Team not found by id " + id));
    }

    @Override
    public boolean existsById(UUID id) {
        return teamRepository.existsById(id);
    }
}
