package org.ferris.generateclient.jpatest;

import org.ferris.resolving.sqlgrammarexception.UserKey;
import org.ferris.resolving.sqlgrammarexception.User;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class OrderIT 
{
    private static Logger log = Logger.getLogger(OrderIT.class);

    private EntityManager em;
    private UserKey orderKey;
    @Before
    public void setEntityManager() throws Exception 
    {
        try {
            EntityManagerFactory emf
                    = Persistence.createEntityManagerFactory("SNAPSHOTPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Before
    public void setOrderKey() throws Exception 
    {
        orderKey = new UserKey();
        
        orderKey.setLastName("red");
        orderKey.setZipCode(90210L);
        orderKey.setBirthday(
            new Timestamp(
                new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.S")
                    .parse("1977-01-30-10.11.30.766")
                    .getTime()
           )
        );
    }
    
    @Test
    public void findOrder() throws Exception 
    {
        assertNotNull("OrderKey should be initialized", orderKey);
        User orderFound = em.find(User.class, orderKey);
        assertNotNull(
            String.format("Order not found in the database. OrderKey=%s",orderKey)
            , orderFound
        );
    }
    
    
//      // INSERT
//      orderKey = new OrderKey();
//      {
//        orderKey.setNumeric(12345L);
//        orderKey.setText("Shrubbery");
//        orderKey.setTimestamp(new Timestamp(System.currentTimeMillis()));
//      }
//      persist(buildOrder(orderKey));      
//      // DELETE
//      delete(orderKey);
//        em.close();
//        log.info(String.format("DONE"));
//    }
//
//    
//    private static Order persist(Order o) {
//        log.info("ENTER persist()");
//        EntityTransaction t = em.getTransaction();
//        t.begin();
//        em.persist(o);
//        try {
//            t.commit();
//        } catch (Throwable tt) {
//            while (tt != null) {
//                if (tt instanceof java.sql.BatchUpdateException) {
//                    log.fatal("oops", ((java.sql.BatchUpdateException) tt).getNextException());
//                } else {
//                    tt = tt.getCause();
//                }
//            }
//        }
//        log.info(String.format("Order after persist = %s", String.valueOf(o)));
//        return o;
//    }
//
//    private static void delete(OrderKey k) {
//        log.info("ENTER delete()");
//        EntityTransaction t = em.getTransaction();
//        t.begin();
//        Order o = em.find(Order.class, k);
//        log.info(String.format("Order before delete = %s", String.valueOf(o)));
//        log.info(String.format("Remove order"));
//        em.remove(o);
//        log.info(String.format("Commit"));
//        t.commit();
//        log.info(String.format("Order after commit = %s", String.valueOf(o)));
//    }
//
//    private static Order buildOrder(OrderKey k) {
//        log.info("ENTER buildOrder()");
//        Set<OrderItem> orderItems = new HashSet<OrderItem>();
//
//        for (int i = 0; i < 3; i++) {
//            OrderItemKey oik = new OrderItemKey();
//            {
//                oik.setNumeric(k.getNumeric());
//                oik.setText(k.getText());
//                oik.setTimestamp(k.getTimestamp());
//                oik.setTextTwo(String.format("Text-Two-%d", (i + 1)));;
//            }
//
//            OrderItem oi = new OrderItem();
//            {
//                oi.setKey(oik);
//                oi.setOrderName("Herring-" + (i + 1));
//            }
//
//            orderItems.add(oi);
//            try {
//                Thread.sleep(100);
//            } catch (Throwable t) {
//            }
//        }
//
//        Order o = new Order();
//        {
//            o.setKey(k);
//            o.setOrderName("Blue");
//            o.setOrderItems(orderItems);
//        }
//        log.info(String.format("Order built = %s", String.valueOf(o)));
//        return o;
//    }
}
