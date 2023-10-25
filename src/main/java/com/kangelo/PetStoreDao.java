package com.kangelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.Pet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PetStoreDao {

    Pet getPet() {

        Client client = ClientBuilder.newClient();
        //TODO read in URI from properties file
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Pet pet = null;
        try {
            pet = mapper.readValue(response, Pet.class);
        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            //TODO implement log4j
        }
        return pet;
    }
}
