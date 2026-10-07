package backend.service.impl;

import backend.repository.ICanBoRepository;
import backend.repository.impl.CanBoRepository;
import backend.service.ICanBoService;
import entity.CanBo;

import java.util.List;

public class CanBoServiceImpl implements ICanBoService {
    private ICanBoRepository repository;

    public CanBoServiceImpl() {
        this.repository = new CanBoRepository();
    }

    @Override
    public List<CanBo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CanBo> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public boolean deleteByName(String name) {
        return repository.deleteByName(name);
    }

    @Override
    public void updateByName(String name, String newName) {
        repository.updateByName(name, newName);
    }
}