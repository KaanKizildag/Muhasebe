/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Kaan
 */
@Entity
@Data
@Table(name = "urun")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Musteri musteri;

    private float fiyat;
    private int adet;

    @Formula("fiyat * adet * (kdv + 100)/100")
    private float tutar;

    @Formula("(fiyat * adet * (kdv + 100)/100) - tahsilat - havale - (bos_kasa * birim_bos_kasa)")
    private float kalan;

    private float tahsilat;

    @Column(columnDefinition = "default 0",
            name = "bos_kasa")
    private int bosKasa;

    @Column(columnDefinition = "default 0",
            name = "birim_bos_kasa")
    private float birimBosKasa;

    @Column(columnDefinition = "default 18")
    private int kdv;

    private float havale;
    private String isim;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date tarih = new Date(System.currentTimeMillis());

    @Override
    public String toString() {
        return "tutar: " + tutar + " kdv: " + kdv + " tahsilat " + tahsilat;
    }
}
