package ee.valiit.back_bank_26;

public class CityServiceInfo {

        private Integer serviceId = 1;
        private String serviceName = "Raha väljamakse";
        private boolean isSelected = false;


    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
