/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.service.abstracts;

import java.util.List;
import muhasebe.entities.UrunIsmi;

/**
 *
 * @author kaan
 */
// Bu nesne veritabanında bir tablo !!
public interface ProductNameService {

    void insert(UrunIsmi isim);
        
    List<UrunIsmi> getAll();
    
}
