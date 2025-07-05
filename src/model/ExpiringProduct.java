package model;

public class ExpiringProduct extends Product implements Expirable {
        private boolean expired;
        public ExpiringProduct(String name, double price, int quantity , boolean expired) {
            super(name,price,quantity);
            this.expired = expired;
        }
        public boolean isExpired() {
            return expired;
        }

}
