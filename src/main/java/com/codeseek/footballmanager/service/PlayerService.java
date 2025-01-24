package com.codeseek.footballmanager.service;

import com.codeseek.footballmanager.dto.player.PlayerRequestDto;
import com.codeseek.footballmanager.dto.player.PlayerResponseDto;
import com.codeseek.footballmanager.model.Player;
import java.util.List;
import java.util.UUID;

public interface PlayerService {
    PlayerResponseDto createPlayer(PlayerRequestDto playerRequestDto);

    PlayerResponseDto getPlayerById(UUID id);

    List<PlayerResponseDto> getAllPlayers();

    PlayerResponseDto updatePlayer(UUID id, PlayerRequestDto playerRequestDto);

    void deletePlayer(UUID id);

    Player findById(UUID id);
}
