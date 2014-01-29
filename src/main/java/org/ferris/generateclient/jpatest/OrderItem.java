/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.generateclient.jpatest;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Michael
 */
@Entity
@Table(name="myorderitems")
public class OrderItem implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  OrderItemKey key;
  
  @Column(name = "name")
  private String orderItemName;
  
  @ManyToOne(optional=false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumns({
        @JoinColumn(name="pk_numeric", referencedColumnName = "pk_numeric", insertable = false, updatable = false),
        @JoinColumn(name="pk_text", referencedColumnName = "pk_text", insertable = false, updatable = false),
        @JoinColumn(name="pk_ts", referencedColumnName = "pk_ts", insertable = false, updatable = false)
    })
  //@ManyToOne
  private Order order;

  public String getOrderItemName() {
    return orderItemName;
  }

  public void setOrderName(String orderItemName) {
    this.orderItemName = orderItemName;
  }

  public OrderItemKey getKey() {
    return key;
  }

  public void setKey(OrderItemKey key) {
    this.key = key;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 47 * hash + (this.key != null ? this.key.hashCode() : 0);
    hash = 47 * hash + (this.orderItemName != null ? this.orderItemName.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final OrderItem other = (OrderItem) obj;
    if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
      return false;
    }
    if ((this.orderItemName == null) ? (other.orderItemName != null) : !this.orderItemName.equals(other.orderItemName)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "OrderItem{" + "key=" + key + ", orderItemName=" + orderItemName + '}';
  }
  
}
