package dataAccess.beans;

import java.math.BigDecimal;

public class GrantCondition {

    private String grantName;
    private String minDuration;
    private String maxDuration;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(String minDuration) {
        this.minDuration = minDuration;
    }

    public String getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(String maxDuration) {
        this.maxDuration = maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public GrantCondition() {
    }

    //TODO delete this constructor (this is for easy testing)
    public GrantCondition(String grantName, String minDuration, String maxDuration, BigDecimal minAmount, BigDecimal maxAmount) {
        this.grantName = grantName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
}
