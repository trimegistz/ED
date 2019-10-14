public class Book extends Media{

    private int pages;

    public Book(String name, String author, int pages){
        super(name,author);
        this.pages = pages;
    }

    public String toString(){
        return super.toString() + "\npages: " + this.pages;
    }

}
