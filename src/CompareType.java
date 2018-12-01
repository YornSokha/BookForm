import java.util.Comparator;

public class CompareType implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if(book1.getType().equals("Web development")){
            switch (book2.getType()) {
                case "Network":
                    return 1;
                case "Programming":
                    return 1;
                default:
                    return 0;
            }
        }
        if(book1.getType().equals("Network")){
            switch (book2.getType()){
                case "Programming":
                    return 1;
                case "Web development":
                    return -1;
                default:
                    return 0;
            }
        }
        return 0;
    }
}
