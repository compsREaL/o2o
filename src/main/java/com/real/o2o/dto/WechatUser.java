package com.real.o2o.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 微信用户实体类
 * @author: mabin
 * @create: 2019/5/1 18:52
 */
public class WechatUser implements Serializable {

    private static final long serialVersionUID = 1319882503041012530L;

    //openId，标识该公众号下面的该用户的唯一ID
    @JsonProperty("openid")
    private String openId;

    //用户昵称
    @JsonProperty("nickname")
    private String nickName;

    //性别
    @JsonProperty("sex")
    private int sex;

    //省份
    @JsonProperty("province")
    private String province;

    //城市
    @JsonProperty("city")
    private String city;

    //区
    @JsonProperty("country")
    private String country;

    //头像图片地址
    @JsonProperty("headimgurl")
    private String headimgurl;

    //语言
    @JsonProperty("language")
    private String language;

    //用户权限
    @JsonProperty("privilege")
    private String[] privilege;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "WechatUser{" +
                "openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", language='" + language + '\'' +
                ", privilege=" + Arrays.toString(privilege) +
                '}';
    }
}
