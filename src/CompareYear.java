import java.util.Comparator;

public class CompareYear implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        if(book1.getYear() < book2.getYear())
            return 1;
        else if(book1.getYear() == book2.getYear())
            return 0;
        else return -1;
    }
}
