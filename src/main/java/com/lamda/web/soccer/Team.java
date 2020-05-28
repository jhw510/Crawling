package com.lamda.web.soccer;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PUBLIC) @ToString

@Entity(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNo;
    @NotNull @Column(length = 10)
    private String teamId;
    @NotNull @Column(length = 10)
    private String regionName;
    @NotNull @Column(length = 40)
    private String teamName;
   @Column(length = 50)
    private String eTeamName;
    @Column(length = 10)
    private String origYyyy;

    @Column(length =10)
    private String zipCode1;
    @Column(length = 10)
    private String zipCode2;
    @Column(length =80)
    private String address;
    @Column(length =10)
    private String ddd;
    @Column(length =10)
    private String tel;
    @Column(length = 10)
    private String fax;
    @Column(length =50)
    private String homepage;
    @Column(length = 10)
    private String owner;

    @OneToMany(mappedBy = "teamOfPlayer")
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "stadium_id")@NotNull
    private Stadium stadiumOfTeam;


    @Builder
    public Team(
            String teamId,String regionName, String teamName
            ,String eTeamName ,String origYyyy,
            String zipCode1, String zipCode2, String address,
            String ddd, String tel, String fax,
            String homepage, String owner ) {

        this.teamId = teamId;
        this.regionName = regionName;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.origYyyy = origYyyy;

        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.homepage = homepage;
        this.owner = owner;


    }

    public Long getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Long teamNo) {
        this.teamNo = teamNo;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String geteTeamName() {
        return eTeamName;
    }

    public void seteTeamName(String eTeamName) {
        this.eTeamName = eTeamName;
    }

    public String getOrigYyyy() {
        return origYyyy;
    }

    public void setOrigYyyy(String origYyyy) {
        this.origYyyy = origYyyy;
    }

    public String getZipCode1() {
        return zipCode1;
    }

    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    public String getZipCode2() {
        return zipCode2;
    }

    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Stadium getStadiumOfTeam() {
        return stadiumOfTeam;
    }

    public void setStadiumOfTeam(Stadium stadiumOfTeam) {
        this.stadiumOfTeam = stadiumOfTeam;
    }
    public Team(){}
}
