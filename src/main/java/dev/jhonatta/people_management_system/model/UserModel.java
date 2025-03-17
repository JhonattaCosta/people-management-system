package dev.jhonatta.people_management_system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_users")
//Getters and Setters
@Data
//Constructors
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @Column(unique = true)
    private String cpf;

    @Column(name = "img_url")
    private String imgUrl;


}
