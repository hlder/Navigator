package com.epaybank.navigator.bean;

/**
 * 用户的状态，包括有多少动态，关注度，好友，跟买者等等
 * @author liangdong
 */
public class UserState {

	private String userId;
	private String dynamicNum;
	private String attentionNum;
	private String followBuyNum;
	private String friendsNum;
	private String groupNum;
	private String tradeNum;
	private String loginNum;
	private String talkNum;
	private String orderNum;
	private String forwardNum;
	private String praiseNum;
	private String commentNum;
	private String shareNum;
	private String coinNum;
	private String createDate;
	private String updateDate;
	private String groupId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDynamicNum() {
		if(dynamicNum==null){
			return "0";
		}
		return dynamicNum;
	}
	public void setDynamicNum(String dynamicNum) {
		this.dynamicNum = dynamicNum;
	}
	public String getAttentionNum() {
		if(attentionNum==null){
			return "0";
		}
		return attentionNum;
	}
	public void setAttentionNum(String attentionNum) {
		this.attentionNum = attentionNum;
	}
	public String getFollowBuyNum() {
		if(followBuyNum==null){
			return "0";
		}
		return followBuyNum;
	}
	public void setFollowBuyNum(String followBuyNum) {
		this.followBuyNum = followBuyNum;
	}
	public String getFriendsNum() {
		if(friendsNum==null){
			return "0";
		}
		return friendsNum;
	}
	public void setFriendsNum(String friendsNum) {
		this.friendsNum = friendsNum;
	}
	public String getGroupNum() {
		if(groupNum==null){
			return "0";
		}
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public String getTradeNum() {
		if(tradeNum==null){
			return "0";
		}
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}
	public String getLoginNum() {
		if(loginNum==null){
			return "0";
		}
		return loginNum;
	}
	public void setLoginNum(String loginNum) {
		this.loginNum = loginNum;
	}
	public String getTalkNum() {
		if(talkNum==null){
			return "0";
		}
		return talkNum;
	}
	public void setTalkNum(String talkNum) {
		this.talkNum = talkNum;
	}
	public String getOrderNum() {
		if(orderNum==null){
			return "0";
		}
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getForwardNum() {
		if(forwardNum==null){
			return "0";
		}
		return forwardNum;
	}
	public void setForwardNum(String forwardNum) {
		this.forwardNum = forwardNum;
	}
	public String getPraiseNum() {
		if(praiseNum==null){
			return "0";
		}
		return praiseNum;
	}
	public void setPraiseNum(String praiseNum) {
		this.praiseNum = praiseNum;
	}
	public String getCommentNum() {
		if(commentNum==null){
			return "0";
		}
		return commentNum;
	}
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	public String getShareNum() {
		if(shareNum==null){
			return "0";
		}
		return shareNum;
	}
	public void setShareNum(String shareNum) {
		this.shareNum = shareNum;
	}
	public String getCoinNum() {
		if(coinNum==null){
			return "0";
		}
		return coinNum;
	}
	public void setCoinNum(String coinNum) {
		this.coinNum = coinNum;
	}
	public String getCreateDate() {
		if(createDate==null){
			return "0";
		}
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		if(updateDate==null){
			return "0";
		}
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getGroupId() {
		if(groupId==null){
			return "0";
		}
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}