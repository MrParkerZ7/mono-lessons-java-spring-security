package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model;

import java.util.Objects;

public class Status {
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnable;

    public Status() {
    }

    public Status(Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnable) {
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnable = isEnable;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(isAccountNonExpired, status.isAccountNonExpired) &&
                Objects.equals(isAccountNonLocked, status.isAccountNonLocked) &&
                Objects.equals(isCredentialsNonExpired, status.isCredentialsNonExpired) &&
                Objects.equals(isEnable, status.isEnable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnable);
    }

    @Override
    public String toString() {
        return "Status{" +
                "isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", isEnable=" + isEnable +
                '}';
    }
}