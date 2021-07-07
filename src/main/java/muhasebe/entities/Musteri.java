/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Kaan
 */
@Entity
@Data
@Table(name = "musteri")
public class Musteri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isim;
    private String telefon;
    private String email;
    @Column(name = "teslimat_noktasi")
    private String teslimatNoktasi;
    @Column(name = "onceki_kalan")
    private float oncekiKalan;

    @ManyToOne
    private Tur tur;

    @Override
    public String toString() {
        return this.teslimatNoktasi + " " + this.isim;
    }

}
