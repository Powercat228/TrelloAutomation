package Api.Objects;

import com.google.gson.JsonArray;

public class Card {
        public String id;
        public String desc;
        public String idBoard;
        public String idList;
        public String name;
        public String url;
        public int comments;
        private JsonArray labels;

//        public String idLabels;

        @Override
        public String toString() {
            return "Card{" +
                    "id='" + id + '\'' +
                    ", desc='" + desc + '\'' +
                    ", idBoard='" + idBoard + '\'' +
                    ", idList='" + idList + '\'' +
                    ", name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    ", comments='" + comments + '\'' +
                    ", labels='" + labels + '\'' +
                    '}';
        }

        public void setId(String id){
                this.id = id;
        }

        public String getId (){
                return id;
        }

        public void setDesc(String desc){
                this.desc = desc;
        }

        public String getDesc (){
                return desc;
        }

        public void setIdBoard(String idBoard){
                this.idBoard = idBoard;
        }

        public String getIdBoard (){
                return idBoard;
        }

        public void setIdList(String idList){
                this.idList = idList;
        }

        public String getIdList (){
                return idList;
        }

        public void setName(String name){
                this.name = name;
        }

        public String getName (){
                return name;
        }
        public void setUrl(String url){
                this.url = url;
        }

        public String getUrl (){
                return url;
        }

        public void setComments(int comments){
                this.comments = comments;
        }

        public int getComments (){
                return comments;
        }

        public JsonArray getLabels() {
                return labels;
        }

        public void setLabels(JsonArray labels) {
                this.labels = labels;
        }

}
