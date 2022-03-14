package br.com.phoebustecnologia.ClientMicroservice.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(){
        super("The client with the specific id does not exist");
    }
}
