package com.launchacademy.mallmadness.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="stores")
public class Store {
  @Id
  @SequenceGenerator(name="store_generator", sequenceName = "stores_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @Column(name="name", nullable = false)
  private String name;

  @Column(name="type")
  private String type;

  @Column(name="average_cost")
  private Integer average_cost;

  @Column(name="operating_status")
  private Boolean operating_status;
}
