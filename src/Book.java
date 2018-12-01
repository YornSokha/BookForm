public class Book {
    private String title, description, type;
    private String year;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return Integer.parseInt(year);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return title + "    " +
                description + "    " +
                type + "    " +
                year;
    }

    public Book(String title, String description, String year, String type) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.type = type;
    }
}
