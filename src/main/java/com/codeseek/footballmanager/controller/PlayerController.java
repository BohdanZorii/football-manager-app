package com.codeseek.footballmanager.controller;

import com.codeseek.footballmanager.dto.player.PlayerRequestDto;
import com.codeseek.footballmanager.dto.player.PlayerResponseDto;
import com.codeseek.footballmanager.service.PlayerService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
@Validated
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponseDto> createPlayer(
        @RequestBody @Valid PlayerRequestDto playerRequestDto) {
        PlayerResponseDto createdPlayer = playerService.createPlayer(playerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> getPlayerById(@PathVariable UUID id) {
        PlayerResponseDto player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayers() {
        List<PlayerResponseDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> updatePlayer(
        @PathVariable UUID id,
        @RequestBody @Valid PlayerRequestDto playerRequestDto
    ) {
        PlayerResponseDto updatedPlayer = playerService.updatePlayer(id, playerRequestDto);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable UUID id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}