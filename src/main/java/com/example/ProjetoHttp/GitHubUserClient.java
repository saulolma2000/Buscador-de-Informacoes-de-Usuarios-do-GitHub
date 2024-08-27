package com.example.ProjetoHttp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GitHubUserClient {

    public static void main(String[] args) {
        try {
            String username = "saulolma2000";
            String url = "https://api.github.com/users/" + username;


            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();

            HttpClient httpClient = HttpClient.newBuilder().build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());


            System.out.println("Resposta JSON bruta:");
            System.out.println(response.body());


            ObjectMapper objectMapper = new ObjectMapper();
            GitHubUser user = objectMapper.readValue(response.body(), GitHubUser.class);


            System.out.println("\nInformações do usuário GitHub:");
            System.out.println("Nome: " + user.getName());
            System.out.println("Número de Repositórios Públicos: " + user.getPublicRepos());
            System.out.println("URL do Perfil: " + user.getHtmlUrl());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}