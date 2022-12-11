package ivan.projects.myshop.entity.enums;

public enum OrderStatusType {
     isProcessing,
     isPayment,
     isDelivered;
    private String orderStatusType;

//    OrderStatusType(String statusType) {
//        this.statusType = statusType;
//    }

    public String getOrderStatusType() {
        return orderStatusType;
    }
}
