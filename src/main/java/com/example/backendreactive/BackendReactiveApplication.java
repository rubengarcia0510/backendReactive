package com.example.backendreactive;

import com.example.backendreactive.model.*;
import com.example.backendreactive.repository.GroupsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableWebFlux
public class BackendReactiveApplication implements CommandLineRunner {

    @Autowired
    GroupsRepository groupsRepository;




    public static void main(String[] args) {

        SpringApplication.run(BackendReactiveApplication.class, args);


    }

    @Override
    public void run(String... args) {
        //deleteAll();
        //addSampleData();
        //listAll();
        createFixture();

    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        groupsRepository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");

        //grupo A
        List<Team> teams = new ArrayList<>();


        Team team1 = new Team("Senegal");
        Team team2 = new Team("Holanda");
        Team team3 = new Team("Qatar");
        Team team4 = new Team("Ecuador");


        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposA = new Teams(teams);
        Groups grupoA = new Groups("A", equiposA);



        //grupo b
        team1 = new Team("inglaterra");
        team2 = new Team("estados unidos");
        team3 = new Team("iran");
        team4 = new Team("wales");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposB = new Teams(teams);
        Groups grupoB = new Groups("B", equiposB);

        //grupo C
        team1 = new Team("Argentina");
        team2 = new Team("Arabia Saudita");
        team3 = new Team("Polonia");
        team4 = new Team("Mexico");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposC = new Teams(teams);
        Groups grupoC = new Groups("C", equiposC);

        //grupo D
        team1 = new Team("francia");
        team2 = new Team("Dinamarka");
        team3 = new Team("Australia");
        team4 = new Team("Tunez");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposD = new Teams(teams);
        Groups grupoD = new Groups("D", equiposD);

        //grupo E
        team1 = new Team("Spaña");
        team2 = new Team("Alemania");
        team3 = new Team("Japon");
        team4 = new Team("Costa Rica");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposE = new Teams(teams);
        Groups grupoE = new Groups("E", equiposE);

        //grupo F
        team1 = new Team("Belgica");
        team2 = new Team("Marruecos");
        team3 = new Team("Croacia");
        team4 = new Team("Canada");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposF = new Teams(teams);
        Groups grupoF = new Groups("F", equiposF);

        //grupo G
        team1 = new Team("Brasil");
        team2 = new Team("Serbia");
        team3 = new Team("Suiza");
        team4 = new Team("Camerun");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposG = new Teams(teams);
        Groups grupoG = new Groups("G", equiposG);

        //grupo H
        team1 = new Team("Portugal");
        team2 = new Team("Uruguay");
        team3 = new Team("Ghana");
        team4 = new Team("Korea Del Sur");

        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Teams equiposH = new Teams(teams);
        Groups grupoH = new Groups("H", equiposH);

        groupsRepository.save(grupoA);
        groupsRepository.save(grupoB);
        groupsRepository.save(grupoC);
        groupsRepository.save(grupoD);
        groupsRepository.save(grupoE);
        groupsRepository.save(grupoF);
        groupsRepository.save(grupoG);
        groupsRepository.save(grupoH);


    }

    public void listAll() {
        System.out.println("Listing sample data");

        groupsRepository.findAll().forEach(element->System.out.println(element.toString()));
    }

    private void createFixture(){
        System.out.println("Create fixture");
        Optional<Groups> variable = groupsRepository.findById("A");
        variable.ifPresent(element->{
            System.out.println(element);
        });

    }
}
