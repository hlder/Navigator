package com.epaybank.navigator.utils;

/**
 * ��ȡ���е�url��ַ
 * @author liangdong
 *
 */
public class UrlFactory {
	/**
	 * ��¼��action
	 */
	private static final String action_login="member/user/login.json";
	/**
	 * ����ȯ�̵�action
	 */
	private static final String action_brokers="/member/khno/query/queryUserKhnosList.html";
	/**
	 * �ҵ�Ǯ�� action
	 */
	private static final String action_my_wallet="/member/wallet/findUserWallet.html";
	/**
	 * ��������
	 */
	private static final String action_invite="/page/member/person/inviteManage/invite.jsp";
	/**
	 * ϵͳ��Ϣ
	 */
	private static final String action_system_notice="/member/userMessage/systemManage.html?type=1";
	/**
	 * ���ѹ���
	 */
	private static final String action_friends_mgr="/member/friend/query/addInit.html";
	/**
	 * ��ȡ������Ϣ�������Һͺ���
	 */
	private static final String action_persion_info="member/user/heinfo.html";
	/**
	 * ��ȡ�û�״̬
	 */
	private static final String action_gain_user_state="member/user/statRecord.json";
	/**
	 * ��ȡ�û���ϸ��Ϣ
	 */
	private static final String action_gain_my_info="member/user/myinfo.json";
	
	
	
	/**
	 * ��ȡ�ҵ���ϸ��Ϣ
	 * @return
	 */
	public static String gainMyInfo(){
		return AppParams.getBaseUrl()+action_gain_my_info;
	}
	/**
	 * ��ȡ�û���״̬��Ϣ
	 * @return
	 */
	public static String gainUserStates(String userId){
		return AppParams.getBaseUrl()+action_gain_user_state+"?userId="+userId;
	}
	/**
	 * ��¼��URL
	 */
	public static String Login(String username,String password){
		return AppParams.getBaseUrl()+action_login+"?userName="+username+"&password="+password;
	}
	
	/**
	 * ����ȯ��
	 */
	public static String associatedBrokers(){
		return AppParams.getBaseUrl()+action_brokers;
	}
	
	/**
	 * �ҵ�Ǯ��
	 */
	public static String myWallet(){
		return AppParams.getBaseUrl()+action_my_wallet;
	}
	/**
	 *  ��������
	 */
	public static String inviteGift(){
		return AppParams.getBaseUrl()+action_invite;
	}
	/**
	 * ϵͳ��Ϣ
	 */
	public static String systemNotice(){
		return AppParams.getBaseUrl()+action_system_notice;
	}
	/**
	 * ���ѹ���
	 */
	public static String friendsMgr(){
		return AppParams.getBaseUrl()+action_friends_mgr;
	}
	/**
	 * ��ȡ������Ϣ�������Һͺ���
	 */
	public static String persionInfo(String userId){
		return AppParams.getBaseUrl()+action_persion_info+"?userId="+userId;
	}
	
	
}