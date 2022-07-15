package com.cursosdedesarrollo.microserviciospring.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type_1")
    private String type_1;
    @Column(name = "type_2")
    private String type_2;
    @Column(name = "total")
    private Integer total;
    @Column(name = "hp")
    private Integer hp;
    @Column(name = "attack")
    private Integer attack;
    @Column(name = "defense")
    private Integer defense;
    @Column(name = "s_attack")
    private Integer s_attack;
    @Column(name = "s_defense")
    private Integer s_defense;
    @Column(name = "speed")
    private Integer speed;
    @Column(name = "generation")
    private Integer generation;
    private Boolean legendary;




    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type_1='" + type_1 + '\'' +
                ", type_2='" + type_2 + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", s_attack=" + s_attack +
                ", s_defense=" + s_defense +
                ", speed=" + speed +
                ", generation=" + generation +
                ", legendary=" + legendary +
                '}';
    }
}
