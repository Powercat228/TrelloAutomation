package helperClasses;

import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ApiManager {

    private WebTarget target;

    public ApiManager() {
        Client client = ClientBuilder.newClient();
        target = client.target("https://api.trello.com");
    }

    public String createBoard(){
        JsonNode responseMsg = target.path("/1/boards/").request()
                .post(Entity.form(new MultivaluedHashMap<String, String>(){{add("key", "2bccaa41b821ec645f738cc2a0b8222f");add("token", "1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820");add("name", "My_Board");}}), JsonNode.class);
        String idBoard = responseMsg.get("id").asText();
        return idBoard;
    }

    public String createList(String idBoard){
        JsonNode responseMsg = target.path("/1/lists").request()
                .post(Entity.form(new MultivaluedHashMap<String,
                        String>() {{add("key", "2bccaa41b821ec645f738cc2a0b8222f");
                        add("token", "1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820");
                        add("name", "My_List");
                        add("idBoard", idBoard);}}), JsonNode.class);
        String idList = responseMsg.get("id").asText();
        return idList;
    }

    public void createCard(String idList){
        JsonNode responseMsg = target.path("/1/cards").request()
                .post(Entity.form(new MultivaluedHashMap<String, String>(){{add("key", "2bccaa41b821ec645f738cc2a0b8222f");add("token", "1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820");add("name", "My_NewCard");add("desc", "test for test");add("idList", idList);}}), JsonNode.class);
        System.out.println(responseMsg);
    }
}

