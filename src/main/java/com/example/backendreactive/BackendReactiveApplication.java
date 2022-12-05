package com.example.backendreactive;

import com.example.backendreactive.model.*;
import com.example.backendreactive.repository.GroupsRepository;
import com.example.backendreactive.repository.TeamsRepository;
import com.example.backendreactive.repository.UserRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.internal.connection.tlschannel.ServerTlsChannel;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebFlux
public class BackendReactiveApplication implements CommandLineRunner {
    @Autowired
    UserRepository repository;

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    TeamsRepository teamsRepository;




    public static void main(String[] args) {

        SpringApplication.run(BackendReactiveApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        deleteAll();
        addSampleData();
        listAll();

    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
        groupsRepository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");
        repository.save(new Users("Jack Bauer", "New York", 11111d));
        repository.save(new Users("Harvey Spectre", "London", 22222d));
        repository.save(new Users("Mike Ross", "New Jersey", 333333d));
        repository.save(new Users("Louise Litt", "Kathmandu", 44444d));

        Team team1=new Team("Argentina");
        Team team2=new Team("Arabia Saudita");
        Team team3=new Team("Polonia");
        Team team4=new Team("Mexico");
        Group grupoC=new Group();
        grupoC.setName("C");
        List<Team> teams=new ArrayList<>();

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposX=new Teams(teams);
        Groups grupoX=new Groups("C",equiposX);
        groupsRepository.save(grupoX);
        team1=new Team("Senegal");
        team2=new Team("Holanda");
        team3=new Team("Qatar");
        team4=new Team("Ecuador");
        teams=new ArrayList<>();

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposA=new Teams(teams);
        Groups grupoA=new Groups("A",equiposA);
        groupsRepository.save(grupoA);





    }

    public void listAll() {
        System.out.println("Listing sample data");
        repository.findAll().forEach(u -> System.out.println(u));
        groupsRepository.findAll().forEach(element->System.out.println(element.toString()));
    }
}
