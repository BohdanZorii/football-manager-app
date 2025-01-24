package com.codeseek.footballmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
@EqualsAndHashCode
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private BigDecimal budget;

    @Column(nullable = false)
    private double commissionRate;

    @OneToMany(mappedBy = "team")
    @EqualsAndHashCode.Exclude
    private List<Player> players;
}

