public class Video extends Media {

    private int length;

    public Video(String name, String author, int length){
        super(name,author);
        this.length = length;
    }
}
