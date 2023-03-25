package com.rebel.alliance.quasar.fire.core.entity.satellite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "satellite")
public class Satellite {
    @Id
    @Column(name= "name", nullable = false, unique = true)
    public String name;
    public double distance;
    public List<String> message;
}
