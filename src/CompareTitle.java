import java.util.Comparator;

public class CompareTitle implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {

        char t1 = ' ', t2 = ' ';
        if (book1.getTitle() != null){
            t1 = book1.getTitle().charAt(0);
        }
        if (book2.getTitle() != null) {
            t2 = book2.getTitle().charAt(0);
        }
        if(t1 > t2)
            return 1;
        else if( t1 == t2)
            return 0;
        else return -1;
    }
}
