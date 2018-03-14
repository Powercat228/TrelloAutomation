package Api;

import Api.Objects.Board;
import Api.Objects.Card;
import Api.Objects.Listt;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;

public class ApiPattern {
    public static final String KEY = "2bccaa41b821ec645f738cc2a0b8222f";
    public static final String TOKEN = "1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820";

    OkHttpClient client = new OkHttpClient();

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.removeHeader("Content-Type");
        requestBuilder.addHeader("Content-Type", "application/json");
        Request request = requestBuilder
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String get(String url, String json) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
//        Gson gson = new Gson();
//        Card card1 = gson.fromJson(response, Card.class);

        return response.body().string();
    }

    public String put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.removeHeader("Content-Type");
        requestBuilder.addHeader("Content-Type", "application/json");
        Request request = requestBuilder
                .url(url)
                .put(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String delete (String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.removeHeader("Content-Type");
        requestBuilder.addHeader("Content-Type", "application/json");
        Request request = requestBuilder
                .url(url)
                .delete(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    String jsonDeleteCard (String cardId){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + cardId + "\""
                + "}";
    }

    String createJson(String listId){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"idList\":\"" + listId + "\""
                + "}";
    }

    String createJson(String listId, String name){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"idList\":\"" + listId + "\","
                + "\"name\":\"" + name + "\""
                + "}";
    }

    String createJsonBoard(String name){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"name\":\"" + name + "\""
                + "}";
    }

    String createJsonBoardMainField(String name, String desc){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"name\":\"" + name + "\","
                + "\"desc\":\"" + desc + "\""
                + "}";
    }

    String jsonPutCardName (String cardId, String name){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + cardId + "\","
                + "\"name\":\"" + name + "\""
                + "}";
    }

    String jsonPutCardDesc (String cardId, String desc){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + cardId + "\","
                + "\"desc\":\"" + desc + "\""
                + "}";
    }

    String jsonPutCardIdLabels (String cardId, String idLabels){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + cardId + "\","
                + "\"idLabels\":\"" + idLabels + "\""
                + "}";
    }
    String jsonPostCardComment(String cardId, String text){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + cardId + "\","
                + "\"text\":\"" + text + "\""
                + "}";
    }

    String  jsonPutBoardName (String boardId, String name){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"boardId\":\"" + boardId + "\","
                + "\"name\":\"" + name + "\""
                + "}";
    }

    String jsonDeleteBoard (String boardId){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"carId\":\"" + boardId + "\""
                + "}";
    }

    String jsonPostAddLabelsBoard(String boardId, String nameLabels, String colorLabels){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"boardId\":\"" + boardId + "\","
                + "\"nameLabels\":\"" + nameLabels + "\","
                + "\"colorLabels\":\"" +colorLabels + "\""
                + "}";
    }

    String createJsonList(String name, String idBoard){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"name\":\"" + name + "\","
                + "\"idBoard\":\"" + idBoard + "\""
                + "}";
    }

    String  jsonPutListName(String listId, String name){
        return "{\"key\":\"2bccaa41b821ec645f738cc2a0b8222f\","
                + "\"token\":\"1ee949ce33b2c6a8b1d7fb2d6aef536c1597c2cb8ba60044168f227174e3f820\","
                + "\"listId\":\"" + listId + "\","
                + "\"name\":\"" + name + "\""
                + "}";
    }

    // CARD CARD CARD CARD CARD CARD CARD

    public Card postCreateCard (String listId, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards";
        String json = createJson(listId);
        // System.out.println(json);
        String response = post(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card postCreateCardNeg (String listId, String name, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards";
        String json = createJson(listId, name);
        String response = post(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card getCard (String cardId, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN;
        String json = createJsonBoard(cardId);
        String response = get(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card putUpdateCardName(String cardId, String name, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "?name=" + name + "&key=" + KEY + "&token=" + TOKEN;
        String json = jsonPutCardName(cardId, name);
        String response = put(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card putUpdateCardDesc(String cardId, String desc, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "?desc=" + desc +"&key=" + KEY + "&token=" + TOKEN;
        String json = jsonPutCardDesc(cardId, desc);
        String response = put(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card postAddNewCardComment (String cardId, String text, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "/actions/comments" + "?text=" + text + "&key=" + KEY + "&token=" + TOKEN;
        String json = jsonPostCardComment(cardId, text);
        String response = post(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }

    public Card deleteCard(String cardId, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "?key=" + KEY + "&token=" + TOKEN;
        String json = jsonDeleteCard(cardId);
        String response = delete(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }







    public Card putUpdateCardIdLabels(String cardId, String idLabels, Card card) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/cards/" + cardId + "?idLabels=" + idLabels +"&key=" + KEY + "&token=" + TOKEN;
        String json = jsonPutCardIdLabels(cardId, idLabels);
        String response = put(url, json);
        card = gson.fromJson(response, Card.class);
        return card;
    }









// BOARD BOARD BOARD BOARD BOARD BOARD

    public Board postCreateBoard (String name, Board board) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/boards";
        String json = createJsonBoard(name);
        String response = post(url, json);
        board = gson.fromJson(response, Board.class);
        return board;
    }

    public Board putUpdateBoardName (String boardId, String name, Board board) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/boards/" + boardId +"?key=" + KEY + "&token=" + TOKEN;
        String json = jsonPutBoardName(boardId, name);
        String response = put(url, json);
        board = gson.fromJson(response, Board.class);
        return board;
    }

    public Board deleteBoard (String boardId, Board board) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/boards/" + boardId + "?key=" + KEY + "&token=" + TOKEN;
        String json = jsonDeleteBoard(boardId);
        String response = delete(url, json);
        board = gson.fromJson(response, Board.class);
        return board;
    }

    public Board postAddLabelsBoard (String boardId, String nameLabels, String colorLabels, Board board) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/boards/" + boardId + "/labels?name=" + nameLabels +
                "&color=" +colorLabels + "&key=" + KEY + "&token=" + TOKEN;
        String json = jsonPostAddLabelsBoard(boardId, nameLabels, colorLabels);
        String response = post(url, json);
        board = gson.fromJson(response, Board.class);
        return board;
    }

// LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST LIST

    public Listt postCreateList (String name, String idBoard, Listt listt) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/lists";
        String json = createJsonList(name, idBoard);
        String response = post(url, json);
        listt = gson.fromJson(response, Listt.class);
        return listt;
    }

    public Listt putUpdateListName (String listId, String name, Listt listt) throws IOException {
        Gson gson = new Gson();
        String url = "https://api.trello.com/1/lists/" + listId +"?key=" + KEY + "&token=" + TOKEN;
        String json = jsonPutListName(listId, name);
        String response = put(url, json);
        listt = gson.fromJson(response, Listt.class);
        return listt;
    }


}
