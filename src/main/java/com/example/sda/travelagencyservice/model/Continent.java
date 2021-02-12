package com.example.sda.travelagencyservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "continent")
    private List<Country> countries;
}
