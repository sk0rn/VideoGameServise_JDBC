package repository.dao.game.interfaces;

import pojo.game.Platform;

import java.util.List;

public interface PlatformDao {

    boolean add(Platform platform);

    Platform getById(Integer id);

    List<Platform> getAll();
}
