package repository.dao.game.interfaces;

import pojo.game.Publisher;

import java.util.List;

public interface PublisherDao {

    boolean add(Publisher pub);

    Publisher getById(Integer id);

    List<Publisher> getAll();
}
