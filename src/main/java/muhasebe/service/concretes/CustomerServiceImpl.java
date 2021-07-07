/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.service.concretes;

import java.util.List;
import muhasebe.entities.Musteri;
import muhasebe.repository.Database;
import muhasebe.service.abstracts.CustomerService;

/**
 *
 * @author kaan
 */
public class CustomerServiceImpl implements CustomerService {

    private final Database database = Database.getInstance();

    public static CustomerService INSTANCE;

    private CustomerServiceImpl() {

    }

    public static CustomerService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void insert(Musteri musteri) {
        database.insertCustomer(musteri);
    }

    @Override
    public List<Musteri> getAll() {
        return database.getCustomers();
    }

    @Override
    public Musteri getById(int id) {
        return database.getById(id);
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(Musteri musteri) {
    }

}
