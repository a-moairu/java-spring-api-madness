package com.launchacademy.mallmadness.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

  @NotNull
  @Column(name="name", nullable = false)
  private String name;

  @NotNull
  @Column(name="type")
  private String type;

  @NotNull
  @Min(1)
  @Max(5)
  @Column(name="average_cost")
  private Integer average_cost;

  @NotNull
  @Column(name="operating_status")
  private Boolean operating_status;
}
