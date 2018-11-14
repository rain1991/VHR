package org.sang.bean;

import java.util.Date;

/**
 * 人事奖励惩罚的激励机制对象
 *
 * @author ZongXin
 * @create 2018-11-13 17:34
 */
public class PersonnelIncentive {

    private Long id;
    private Long workID;
    private String name;
    private int type;//0表示惩罚 1表示奖励
    private double amount;//金额
    private Date insertDate;
    private String reason;
    private String remake;
    private int isDel; //0表示正常，1表示删除
    private Date delDate;//删除日期

    public PersonnelIncentive() {
    }

    public PersonnelIncentive(Long id, Long workID, String name, int type, double amount, Date insertDate, String reason, String remake, int isDel, Date delDate) {
        this.id = id;
        this.workID = workID;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.insertDate = insertDate;
        this.reason = reason;
        this.remake = remake;
        this.isDel = isDel;
        this.delDate = delDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkID() {
        return workID;
    }

    public void setWorkID(Long workID) {
        this.workID = workID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }
}
