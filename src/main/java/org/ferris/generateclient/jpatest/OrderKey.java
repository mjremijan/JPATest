/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.generateclient.jpatest;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Michael
 */
@Embeddable
public class OrderKey implements Serializable {
    
  @Column(name="pk_text")
  private String text;
    
  @Column(name="pk_numeric")
  private Long numeric;
      
  @Column(name="pk_ts")
  private Timestamp timestamp;
    
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getNumeric() {
    return numeric;
  }

  public void setNumeric(Long numeric) {
    this.numeric = numeric;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + (this.text != null ? this.text.hashCode() : 0);
    hash = 97 * hash + (this.numeric != null ? this.numeric.hashCode() : 0);
    hash = 97 * hash + (this.timestamp != null ? this.timestamp.hashCode() : 0);
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
    final OrderKey other = (OrderKey) obj;
    if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
      return false;
    }
    if (this.numeric != other.numeric && (this.numeric == null || !this.numeric.equals(other.numeric))) {
      return false;
    }
    if (this.timestamp != other.timestamp && (this.timestamp == null || !this.timestamp.equals(other.timestamp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "OrderKey{" + "text=" + text + ", numeric=" + numeric + ", timestamp=" + timestamp + '}';
  }
  
  
}
