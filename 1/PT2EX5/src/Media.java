public class Media {


    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Media(){
        this.name = "unknown";
        this.author ="unknown";
    }

    public Media(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String toString(){
        return("name: " + this.name + "\nauthor: " + this.author);
    }

}
