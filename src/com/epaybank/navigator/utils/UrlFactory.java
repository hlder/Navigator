package com.epaybank.navigator.utils;

/**
 * 获取所有的url地址
 * @author liangdong
 *
 */
public class UrlFactory {
	/**
	 * 登录的action
	 */
	private static final String action_login="member/user/login.json";
	/**
	 * 关联券商的action
	 */
	private static final String action_brokers="/member/khno/query/queryUserKhnosList.html";
	/**
	 * 我的钱包 action
	 */
	private static final String action_my_wallet="/member/wallet/findUserWallet.html";
	/**
	 * 邀请有礼
	 */
	private static final String action_invite="/page/member/person/inviteManage/invite.jsp";
	/**
	 * 系统消息
	 */
	private static final String action_system_notice="/member/userMessage/systemManage.html?type=1";
	/**
	 * 好友管理
	 */
	private static final String action_friends_mgr="/member/friend/query/addInit.html";
	/**
	 * 获取个人信息，包括我和好友
	 */
	private static final String action_persion_info="member/user/heinfo.html";
	/**
	 * 获取用户状态
	 */
	private static final String action_gain_user_state="member/user/statRecord.json";
	/**
	 * 获取用户详细信息
	 */
	private static final String action_gain_my_info="member/user/myinfo.json";
	
	
	
	/**
	 * 获取我的详细信息
	 * @return
	 */
	public static String gainMyInfo(){
		return AppParams.getBaseUrl()+action_gain_my_info;
	}
	/**
	 * 获取用户的状态信息
	 * @return
	 */
	public static String gainUserStates(String userId){
		return AppParams.getBaseUrl()+action_gain_user_state+"?userId="+userId;
	}
	/**
	 * 登录的URL
	 */
	public static String Login(String username,String password){
		return AppParams.getBaseUrl()+action_login+"?userName="+username+"&password="+password;
	}
	
	/**
	 * 关联券商
	 */
	public static String associatedBrokers(){
		return AppParams.getBaseUrl()+action_brokers;
	}
	
	/**
	 * 我的钱包
	 */
	public static String myWallet(){
		return AppParams.getBaseUrl()+action_my_wallet;
	}
	/**
	 *  邀请有礼
	 */
	public static String inviteGift(){
		return AppParams.getBaseUrl()+action_invite;
	}
	/**
	 * 系统消息
	 */
	public static String systemNotice(){
		return AppParams.getBaseUrl()+action_system_notice;
	}
	/**
	 * 好友管理
	 */
	public static String friendsMgr(){
		return AppParams.getBaseUrl()+action_friends_mgr;
	}
	/**
	 * 获取个人信息，包括我和好友
	 */
	public static String persionInfo(String userId){
		return AppParams.getBaseUrl()+action_persion_info+"?userId="+userId;
	}
	
	
}