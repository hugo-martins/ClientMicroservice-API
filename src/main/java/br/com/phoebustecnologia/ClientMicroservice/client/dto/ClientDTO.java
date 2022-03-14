package br.com.phoebustecnologia.ClientMicroservice.client.dto;

import br.com.phoebustecnologia.ClientMicroservice.client.model.Client;
import br.com.phoebustecnologia.ClientMicroservice.client.model.SexClient;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO implements Serializable {
    private static final long SerialVersionId = 1L;
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer age;

    @NotNull
    private String phone;

    @NotNull
    private String email;


    private SexClient sex;

    public static ClientDTO clientDTO(Client clientEntity){
        return builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .age(clientEntity.getAge())
                .phone(clientEntity.getPhone())
                .email(clientEntity.getEmail())
                .sex(clientEntity.getSex())
                .build();

    }

    public static List<ClientDTO> ListFromAllClients (List<Client> clients) {
        return clients.stream().map(ClientDTO::clientDTO).collect(Collectors.toList());
    }


    public static ClientDTO clientSavedDTO(Client clientEntity){
        return builder()
                .name(clientEntity.getName())
                .age(clientEntity.getAge())
                .sex(clientEntity.getSex())
                .email(clientEntity.getEmail())
                .phone(clientEntity.getPhone())
                .build();

    }
    public static ClientDTO clientByEmailDTO(Client clientEntity){
        return builder()
                .email(clientEntity.getEmail())
                .build();

    }
}
