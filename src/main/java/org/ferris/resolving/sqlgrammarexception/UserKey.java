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
public class UserKey implements Serializable 
{
    private static final long serialVersionUID = 131374817387370831L;
    
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "birthday")
    private Timestamp birthday;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 97 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 97 * hash + (this.birthday != null ? this.birthday.hashCode() : 0);
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
        final UserKey other = (UserKey) obj;
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if (this.zipCode != other.zipCode && (this.zipCode == null || !this.zipCode.equals(other.zipCode))) {
            return false;
        }
        if (this.birthday != other.birthday && (this.birthday == null || !this.birthday.equals(other.birthday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserKey{" + "lastName=" + lastName + ", zipCode=" + zipCode + ", birthday=" + birthday + '}';
    }
}
