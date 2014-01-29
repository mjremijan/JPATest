package org.ferris.generateclient.jpatest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class OrderMain 
{
    private static Logger log = Logger.getLogger(OrderMain.class);
    
    private static EntityManager em;
    private static void setEntityManager() throws Exception {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SNAPSHOTPU");
      log.info(String.format("EntityManagerFactory = %s",String.valueOf(emf)));
      
      em = emf.createEntityManager();
      log.info(String.format("EntityManager = %s",String.valueOf(em)));
    }
    
    
    public static void main( String[] args )            
    throws Exception
    {
      log.info(String.format("WELCOME TO JPATEST"));
      
      setEntityManager();
      
      OrderKey orderKey = new OrderKey();
      // FIND      
      {
        orderKey.setNumeric(12345L);
        orderKey.setText("Shrubbery");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date date = sdf.parse("2014-01-29 14:03:08.837-06");
        orderKey.setTimestamp(new Timestamp(date.getTime()));
      }
      find(orderKey);  
      
      // INSERT
      orderKey = new OrderKey();
      {
        orderKey.setNumeric(12345L);
        orderKey.setText("Shrubbery");
        orderKey.setTimestamp(new Timestamp(System.currentTimeMillis()));
      }
      persist(buildOrder(orderKey));      
      
      // DELETE
      delete(orderKey);
      
      em.close();
      log.info(String.format("DONE"));
    }
    
    
    private static Order find(OrderKey k) {
      log.info("ENTER find()");
      Order orderFound = em.find(Order.class, k);
      log.info(String.format("Order found = %s",String.valueOf(orderFound)));
      return orderFound;
    }
    
    private static Order persist(Order o) {
      log.info("ENTER persist()");
      EntityTransaction t = em.getTransaction();
      t.begin();
      em.persist(o);  
      try { 
        t.commit();
      } 
      catch (Throwable tt) 
      {
        while (tt != null) {
          if (tt instanceof java.sql.BatchUpdateException) {
            log.fatal("oops", ((java.sql.BatchUpdateException)tt).getNextException());
          } else {
            tt = tt.getCause();
          }
        }
      }
      log.info(String.format("Order after persist = %s",String.valueOf(o))); 
      return o;
    }
    
    private static void delete(OrderKey k) {
      log.info("ENTER delete()");
      EntityTransaction t = em.getTransaction();
      t.begin();
      Order o = em.find(Order.class, k);
      log.info(String.format("Order before delete = %s",String.valueOf(o)));
      log.info(String.format("Remove order"));
      em.remove(o);
      log.info(String.format("Commit"));
      t.commit();
      log.info(String.format("Order after commit = %s",String.valueOf(o)));
    }
      
    private static Order buildOrder(OrderKey k)
    {
      log.info("ENTER buildOrder()");
      Set<OrderItem> orderItems = new HashSet<OrderItem>();
      
      for (int i=0; i<3; i++) {    
        OrderItemKey oik = new OrderItemKey(); {
          oik.setNumeric(k.getNumeric());
          oik.setText(k.getText());          
          oik.setTimestamp(k.getTimestamp());
          oik.setTextTwo(String.format("Text-Two-%d",(i+1)));;
        }
        
        OrderItem oi = new OrderItem(); {
          oi.setKey(oik);
          oi.setOrderName("Herring-" + (i + 1));
        }
        
        orderItems.add(oi);
        try {
          Thread.sleep(100);
        } catch (Throwable t) {}
      }
      
      Order o = new Order(); {
        o.setKey(k);
        o.setOrderName("Blue");
        o.setOrderItems(orderItems);
      }
      log.info(String.format("Order built = %s",String.valueOf(o)));
      return o;
    }   
}
