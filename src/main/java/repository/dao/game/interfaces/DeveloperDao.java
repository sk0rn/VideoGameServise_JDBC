package repository.dao.game.interfaces;

import pojo.game.Developer;

public interface DeveloperDao {

    boolean add(Developer dev);

    Developer getById(Integer id);
}
