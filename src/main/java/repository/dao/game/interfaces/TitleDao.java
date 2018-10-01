package repository.dao.game.interfaces;

import pojo.game.Title;

public interface TitleDao {

    boolean add(Title title);

    Title getById(Integer id);
}
