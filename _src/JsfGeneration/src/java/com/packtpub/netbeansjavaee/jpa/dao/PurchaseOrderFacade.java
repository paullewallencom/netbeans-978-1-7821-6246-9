/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.netbeansjavaee.jpa.dao;

import com.packtpub.netbeansjavaee.jpa.entity.PurchaseOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class PurchaseOrderFacade extends AbstractFacade<PurchaseOrder> {
    @PersistenceContext(unitName = "JsfGenerationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseOrderFacade() {
        super(PurchaseOrder.class);
    }
    
}
