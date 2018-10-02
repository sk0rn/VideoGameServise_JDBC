package repository.dao.game.interfaces;

import pojo.game.Title;

import java.util.List;

public interface TitleDao {

    boolean add(Title title);

    Title getById(Integer id);

    List<Title> getAll();
}
