package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.dto.player.PlayerRequestDto;
import com.codeseek.footballmanager.dto.player.PlayerResponseDto;
import com.codeseek.footballmanager.mapper.PlayerMapper;
import com.codeseek.footballmanager.model.Player;
import com.codeseek.footballmanager.model.Team;
import com.codeseek.footballmanager.repository.PlayerRepository;
import com.codeseek.footballmanager.service.PlayerService;
import com.codeseek.footballmanager.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;

    @Transactional
    @Override
    public PlayerResponseDto createPlayer(PlayerRequestDto dto) {
        UUID teamId = dto.teamId();
        Team team = teamService.findById(teamId);

        Player player = playerMapper.toEntity(dto, team);
        playerRepository.save(player);
        return playerMapper.toResponseDto(player);
    }

    @Override
    public PlayerResponseDto getPlayerById(UUID id) {
        Player player = findById(id);
        return playerMapper.toResponseDto(player);
    }

    @Override
    public List<PlayerResponseDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return playerMapper.toResponseDtoList(players);
    }

    @Transactional
    @Override
    public PlayerResponseDto updatePlayer(UUID id, PlayerRequestDto playerRequestDto) {
        Player player = findById(id);

        playerMapper.updatePlayerFromDto(playerRequestDto, player);
        playerRepository.save(player);
        return playerMapper.toResponseDto(player);
    }

    @Override
    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player findById(UUID id) {
        return playerRepository.findById(id).orElseThrow(()
            -> new EntityNotFoundException("Player not found by id " + id));
    }
}
