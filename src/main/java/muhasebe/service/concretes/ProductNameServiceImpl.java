/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.service.concretes;

import java.util.List;
import muhasebe.entities.UrunIsmi;
import muhasebe.repository.Database;
import muhasebe.service.abstracts.ProductNameService;

/**
 *
 * @author kaan
 */
public class ProductNameServiceImpl implements ProductNameService {

    private final Database database = Database.getInstance();

    public static ProductNameService INSTANCE;

    private ProductNameServiceImpl() {

    }

    public static ProductNameService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductNameServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void insert(UrunIsmi isim) {
        database.insertProductName(isim);
    }

    @Override
    public List<UrunIsmi> getAll() {
        return database.getAllProductNames();
    }

}
