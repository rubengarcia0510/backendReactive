package com.example.backendreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "teams")
public class Teams {
    @Id
    private String id;
    private List<Team> team;

    public Teams(List<Team> team) {
        this.team = team;
    }
}
