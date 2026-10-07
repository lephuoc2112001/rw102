package backend.repository;

import entity.CanBo;
import java.util.List;

public interface ICanBoRepository {
    List<CanBo> findAll();
    List<CanBo> findByName(String name);
    boolean deleteByName(String name);
    void updateByName(String name, String newName);
}
