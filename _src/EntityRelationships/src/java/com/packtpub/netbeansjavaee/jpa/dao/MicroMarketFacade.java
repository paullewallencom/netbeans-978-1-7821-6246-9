/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.jpa.dao;

import com.packtpub.netbeansjavaee.jpa.entity.MicroMarket;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class MicroMarketFacade extends AbstractFacade<MicroMarket> {
    @PersistenceContext(unitName = "JpaIntroPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MicroMarketFacade() {
        super(MicroMarket.class);
    }
    
}
