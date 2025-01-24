package com.codeseek.footballmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transfers")
@Getter
@Setter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_team_id", nullable = false)
    private Team fromTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_team_id", nullable = false)
    private Team toTeam;

    @Column(nullable = false)
    private BigDecimal transferAmount;

    @Column(nullable = false)
    private BigDecimal commission;
}
