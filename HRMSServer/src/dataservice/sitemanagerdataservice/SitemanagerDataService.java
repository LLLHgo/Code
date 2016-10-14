package dataservice.sitemanagerdataservice;

import po.SitemanagerPO;
public interface SitemanagerDataService {
	/**
	 * 从数据库中得到网站管理人员账户信息
	 * @return 网站管理人员PO
	 */
	public SitemanagerPO getAccount();
}
