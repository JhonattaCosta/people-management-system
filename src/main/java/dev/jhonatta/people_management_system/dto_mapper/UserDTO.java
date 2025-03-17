package dev.jhonatta.people_management_system.dto_mapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Long id;
    private String name;
    private String email;
    private int age;
    private String cpf;
    private String imgUrl;

}
