package fr.jydet.polytech;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class UserClient {

    public static void main(String[] args) {
        Client c = ClientBuilder.newClient();
        WebTarget target = c.target("http://localhost:8080/RESTServer_war_exploded/api/UserService/");
        WebTarget usersTarget = target.path("users");
        Invocation.Builder request = usersTarget.request(MediaType.APPLICATION_XML_TYPE);
        List<User> user = request.get(Response.class)
                .readEntity(new GenericType<List<User>>() {});
        System.out.println(user);
    }
}
