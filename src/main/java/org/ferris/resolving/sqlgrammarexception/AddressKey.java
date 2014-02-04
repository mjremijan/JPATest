/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ferris.resolving.sqlgrammarexception;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Michael
 */
@Embeddable
public class AddressKey implements Serializable 
{
    private static final long serialVersionUID = 34798740872445L;
  
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "birthday")
    private Timestamp birthday;

    @Column(name = "address")
    private String address;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 59 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 59 * hash + (this.birthday != null ? this.birthday.hashCode() : 0);
        hash = 59 * hash + (this.address != null ? this.address.hashCode() : 0);
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
        final AddressKey other = (AddressKey) obj;
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if (this.zipCode != other.zipCode && (this.zipCode == null || !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        if (this.birthday != other.birthday && (this.birthday == null || !this.birthday.equals(other.birthday))) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AddressKey{" + "lastName=" + lastName + ", zipCode=" + zipCode + ", birthday=" + birthday + ", address=" + address + '}';
    }
}
