/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.service.abstracts;

import java.util.List;
import muhasebe.entities.Musteri;

/**
 *
 * @author kaan
 */
public interface CustomerService {

    void insert(Musteri musteri);

    List<Musteri> getAll();

    Musteri getById(int id);

    void delete(int id);

    void update(Musteri musteri);

}
