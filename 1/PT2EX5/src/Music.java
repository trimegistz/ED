public class Music extends Media{

    private int length;
    private String album;

    public Music(String name, String author, int length, String album){
        super(name,author);
        this.length = length;
        this.album = album;

    }
}
