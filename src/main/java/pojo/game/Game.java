package pojo.game;


public class Game {

  private int id;
  private Title title;
  private int quantity;
  private Genre genre;
  private Developer dev;
  private Publisher pub;
  private int releaseYear;
  private Platform platform;
  private int price;

    public Game() {
    }

    public Game(int id, Title title, int quantity,
                Genre genre, Developer dev, Publisher pub,
                int releaseYear, Platform platform, int price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.genre = genre;
        this.dev = dev;
        this.pub = pub;
        this.releaseYear = releaseYear;
        this.platform = platform;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Developer getDev() {
        return dev;
    }

    public void setDev(Developer dev) {
        this.dev = dev;
    }

    public Publisher getPub() {
        return pub;
    }

    public void setPub(Publisher pub) {
        this.pub = pub;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title=" + title +
                ", quantity=" + quantity +
                ", genre=" + genre +
                ", dev=" + dev +
                ", pub=" + pub +
                ", releaseYear=" + releaseYear +
                ", platform=" + platform +
                ", price=" + price +
                '}';
    }
}
