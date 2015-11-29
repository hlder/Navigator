package com.epaybank.navigator.bean;

/**
 * 用户详细信息
 * @author liangdong
 */
public class UserInfo {
	private String sex;
	private String isBindQQ;
	private String companyDuties;
	private String isBindWeibo;
	private String provinceCode;
	private String cityName;
	private String cityCode;
	private String provinceName;
	private String type;
	private String isBindMobile;
	private String isPerfectData;
	private String updateDate;
	private String isBindWeChat;
	private String resume;
	private String bindKhnoNum;
	private String nickName;
	private String age;
	private String userId;
	private String headImgPath;
	private String createDate;
	private String signature;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIsBindQQ() {
		return isBindQQ;
	}
	public void setIsBindQQ(String isBindQQ) {
		this.isBindQQ = isBindQQ;
	}
	public String getCompanyDuties() {
		return companyDuties;
	}
	public void setCompanyDuties(String companyDuties) {
		this.companyDuties = companyDuties;
	}
	public String getIsBindWeibo() {
		return isBindWeibo;
	}
	public void setIsBindWeibo(String isBindWeibo) {
		this.isBindWeibo = isBindWeibo;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getType() {
		if(type==null){
			type="0";
		}
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsBindMobile() {
		return isBindMobile;
	}
	public void setIsBindMobile(String isBindMobile) {
		this.isBindMobile = isBindMobile;
	}
	public String getIsPerfectData() {
		return isPerfectData;
	}
	public void setIsPerfectData(String isPerfectData) {
		this.isPerfectData = isPerfectData;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getIsBindWeChat() {
		return isBindWeChat;
	}
	public void setIsBindWeChat(String isBindWeChat) {
		this.isBindWeChat = isBindWeChat;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getBindKhnoNum() {
		return bindKhnoNum;
	}
	public void setBindKhnoNum(String bindKhnoNum) {
		this.bindKhnoNum = bindKhnoNum;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}