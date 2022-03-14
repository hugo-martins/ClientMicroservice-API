package br.com.phoebustecnologia.ClientMicroservice.client.model;

import br.com.phoebustecnologia.ClientMicroservice.client.dto.ClientDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class Client implements Serializable {
    private static final long SerialVersionID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String phone;

        private String email;


        private Integer age;

        @Enumerated(EnumType.STRING)
        private SexClient sex;

        public Client(Long id, String name, Integer age, SexClient sex) {
        }

        public static Client clientFrom (ClientDTO dto){
            return builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .phone(dto.getPhone())
                    .email(dto.getEmail())
                    .age(dto.getAge())
                    .sex(dto.getSex())
                    .build();
        }
        public static Client clientSaved (ClientDTO dto){
            return builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .phone(dto.getPhone())
                    .email(dto.getEmail())
                    .age(dto.getAge())
                    .sex(dto.getSex())
                    .build();
        }

}
