package com.yc.story.bean;

public class StGoods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_goods.id
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_goods.g_name
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    private String gName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_goods.g_price
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    private Float gPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_goods.g_desc
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    private String gDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column st_goods.g_cost
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    private Double gCost;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_goods.id
     *
     * @return the value of st_goods.id
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_goods.id
     *
     * @param id the value for st_goods.id
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_goods.g_name
     *
     * @return the value of st_goods.g_name
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public String getgName() {
        return gName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_goods.g_name
     *
     * @param gName the value for st_goods.g_name
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_goods.g_price
     *
     * @return the value of st_goods.g_price
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public Float getgPrice() {
        return gPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_goods.g_price
     *
     * @param gPrice the value for st_goods.g_price
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setgPrice(Float gPrice) {
        this.gPrice = gPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_goods.g_desc
     *
     * @return the value of st_goods.g_desc
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public String getgDesc() {
        return gDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_goods.g_desc
     *
     * @param gDesc the value for st_goods.g_desc
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setgDesc(String gDesc) {
        this.gDesc = gDesc == null ? null : gDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column st_goods.g_cost
     *
     * @return the value of st_goods.g_cost
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public Double getgCost() {
        return gCost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column st_goods.g_cost
     *
     * @param gCost the value for st_goods.g_cost
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setgCost(Double gCost) {
        this.gCost = gCost;
    }

}