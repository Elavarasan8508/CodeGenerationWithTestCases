package com.bsit.codegeneration.pojo;

public class Databasechangeloglock {

    private Integer ID;

    private Integer locked;

    private String lockgranted;

    private String lockedby;

    public Databasechangeloglock() {
    }

    public Databasechangeloglock(Integer ID, Integer locked, String lockgranted, String lockedby) {
        this.ID = ID;
        this.locked = locked;
        this.lockgranted = lockgranted;
        this.lockedby = lockedby;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getLockgranted() {
        return lockgranted;
    }

    public void setLockgranted(String lockgranted) {
        this.lockgranted = lockgranted;
    }

    public String getLockedby() {
        return lockedby;
    }

    public void setLockedby(String lockedby) {
        this.lockedby = lockedby;
    }

    public static class Builder {

        private Databasechangeloglock instance = new Databasechangeloglock();

        public Builder ID(Integer ID) {
            instance.setID(ID);
            return this;
        }

        public Builder locked(Integer locked) {
            instance.setLocked(locked);
            return this;
        }

        public Builder lockgranted(String lockgranted) {
            instance.setLockgranted(lockgranted);
            return this;
        }

        public Builder lockedby(String lockedby) {
            instance.setLockedby(lockedby);
            return this;
        }

        public Databasechangeloglock build() {
            return instance;
        }
    }
}
