package com.bsit.codegeneration.record;

public record Databasechangeloglock(Long ID, Long locked, String lockgranted, String lockedby) {

    public static class Builder {

        private Long ID;

        private Long locked;

        private String lockgranted;

        private String lockedby;

        public Builder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public Builder locked(Long locked) {
            this.locked = locked;
            return this;
        }

        public Builder lockgranted(String lockgranted) {
            this.lockgranted = lockgranted;
            return this;
        }

        public Builder lockedby(String lockedby) {
            this.lockedby = lockedby;
            return this;
        }

        public Databasechangeloglock build() {
            return new Databasechangeloglock(ID, locked, lockgranted, lockedby);
        }
    }
}
