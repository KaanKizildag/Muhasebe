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
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Kaan
 */
@Entity
@Data
@Table(name = "kasa")
public class Kasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float butce;
    @Column(name = "stok_iceberg")
    private int stokIceberg;

}
