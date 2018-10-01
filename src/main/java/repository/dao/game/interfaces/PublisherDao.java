package repository.dao.game.interfaces;

import pojo.game.Publisher;

public interface PublisherDao {

    boolean add(Publisher pub);

    Publisher getById(Integer id);
}
