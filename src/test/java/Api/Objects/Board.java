package Api.Objects;

public class Board {
    public String id;
    public String desc;
    public String name;
    public String shortUrl;


    @Override
        public String toString(){
            return "Board{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    ", shortUrl='" + shortUrl + '\'' +
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

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getDesc (){
        return desc;
    }

    public void setShortUrl(String shortUrl){
        this.shortUrl = shortUrl;
    }

    public String getShortUrl(){
        return shortUrl;
    }
}
