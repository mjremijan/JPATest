/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.generateclient.jpatest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Michael
 */
@Entity
@Table(name="myorder")
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @EmbeddedId  
  OrderKey key;
  
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)         
  Collection<OrderItem> orderItems;
  
  @Column(name = "name")
  String orderName;

  public Collection<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(Collection<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  public OrderKey getKey() {
    return key;
  }

  public void setKey(OrderKey key) {
    this.key = key;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + (this.key != null ? this.key.hashCode() : 0);
    hash = 97 * hash + (this.orderItems != null ? this.orderItems.hashCode() : 0);
    hash = 97 * hash + (this.orderName != null ? this.orderName.hashCode() : 0);
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
    final Order other = (Order) obj;
    if (this.key != other.key && (this.key == null || !this.key.equals(other.key))) {
      return false;
    }
    if (this.orderItems != other.orderItems && (this.orderItems == null || !this.orderItems.equals(other.orderItems))) {
      return false;
    }
    if ((this.orderName == null) ? (other.orderName != null) : !this.orderName.equals(other.orderName)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Order{" + "key=" + key + ", orderItems=" + orderItems + ", orderName=" + orderName + '}';
  }
}
