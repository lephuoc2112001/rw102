package backend.controller;

import backend.service.ICanBoService;
import backend.service.impl.CanBoServiceImpl;
import entity.CanBo;

import java.util.List;

public class CanBoController {
    private ICanBoService canBoService;


    public CanBoController() {
        this.canBoService = new CanBoServiceImpl();
    }

    public List<CanBo> findAll() {
        return canBoService.findAll();
    }

    public List<CanBo> findByName(String name) {
        return canBoService.findByName(name);
    }

    public boolean updateByName(String name, String newName) {
        canBoService.updateByName(name, newName);
        return false;
    }
    public boolean deleteByName(String name){
        return canBoService.deleteByName(name);
    }

}
