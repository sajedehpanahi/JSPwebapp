package domainLogic.domainObjects;

import dataAccess.entities.GrantConditionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GrantConditionObject {

    private int grantId;
    private String grantName;
    private int minDuration;
    private int maxDuration;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;

    public GrantConditionObject(String grantName, int minDuration, int maxDuration, BigDecimal minAmount, BigDecimal maxAmount) {
        this.grantName = grantName;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public GrantConditionObject() {
    }

    public int getGrantId() {
        return grantId;
    }

    public void setGrantId(int grantId) {
        this.grantId = grantId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
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

    public static GrantConditionEntity toGrantConditionEntity(GrantConditionObject grantConditionObject){
        return new GrantConditionEntity(grantConditionObject.grantName, grantConditionObject.minDuration, grantConditionObject.maxDuration, grantConditionObject.minAmount, grantConditionObject.maxAmount);
    }

    public static ArrayList<GrantConditionEntity> toLoanTypeEntity(ArrayList<GrantConditionObject> grantConditionObjects){
        ArrayList<GrantConditionEntity> grantConditionEntities = new ArrayList<GrantConditionEntity>();
        for(GrantConditionObject grantConditionObject : grantConditionObjects){
            grantConditionEntities.add(toGrantConditionEntity(grantConditionObject));
        }
        return grantConditionEntities;
    }

    /*public static Set<GrantConditionEntity> toLoanTypeEntity(ArrayList<GrantConditionObject> grantConditionObjects){
        Set<GrantConditionEntity> grantConditionEntities = new HashSet<>();
        for(GrantConditionObject grantConditionObject : grantConditionObjects){
            grantConditionEntities.add(toGrantConditionEntity(grantConditionObject));
        }
        return grantConditionEntities;
    }*/

    public static GrantConditionObject convert(GrantConditionEntity grantConditionEntity){
        return new GrantConditionObject(grantConditionEntity.getGrantName(), grantConditionEntity.getMinDuration(), grantConditionEntity.getMaxDuration(), grantConditionEntity.getMinAmount(), grantConditionEntity.getMaxAmount());
    }
}
