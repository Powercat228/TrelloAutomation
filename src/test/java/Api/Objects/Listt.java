package Api.Objects;

public class Listt {
    public String id;
    public String name;
    public String idBoard;
    public String pos;
    public Boolean closed;

    @Override
    public String toString() {
        return "Listt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", pos='" + pos + '\'' +
                ", closed='" + closed + '\'' +
                '}';
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId (){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void setIdBoard(String idBoard){
        this.idBoard = idBoard;
    }

    public String getIdBoard (){
        return idBoard;
    }

    public void setPos(String pos){
        this.pos = pos;
    }

    public String getPos(){
        return pos;
    }

    public void setClosed(Boolean closed){
        this.closed = closed;
    }

    public Boolean getClosed (){
        return closed;
    }
}
