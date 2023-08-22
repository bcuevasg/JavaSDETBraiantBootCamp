package com.braiant.restassured.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data // inicializa getters or setters recomendado solo para pocos elementos
@JsonIgnoreProperties(ignoreUnknown = true)//necesario para cuando no se quiere declarar todos los elementos de user
public class User {
    private String login;
    private int id;
    @JsonProperty("public_repos")// ayuda a mappear la propiedad del json a la variable que querramos siguiente linea
    private int publicRepos;// necesita llamarse igual que el elemento de la respuesta

    @JsonProperty("twitter_username")
    private String twitterUser;

}
