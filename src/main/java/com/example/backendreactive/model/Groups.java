package com.example.backendreactive.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "groups")
public class Groups {
    @Id
    private String name;

    private Teams teams;

    public Groups(String name, Teams teams) {
        this.name = name;
        this.teams = teams;
    }
}
