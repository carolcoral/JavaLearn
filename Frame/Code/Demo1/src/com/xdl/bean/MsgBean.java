package com.xdl.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MsgBean {
	
	
  
	@Override
	public String toString() {
		return "MsgBean [title=" + title + ", length=" + length + ", friends=" + friends + ", friends2=" + friends2
				+ "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	
	public Set<String> getFriends2() {
		return friends2;
	}
	public void setFriends2(Set<String> friends2) {
		this.friends2 = friends2;
	}
    

	public Map<String, String> getPhones() {
		return phones;
	}
	public void setPhones(Map<String, String> phones) {
		this.phones = phones;
	}
    

	public Properties getPhones2() {
		return phones2;
	}
	public void setPhones2(Properties phones2) {
		this.phones2 = phones2;
	}


	private  String title;
    private  int    length;
    /** 好友的名字列表 */
    private  List<String> friends;
    private  Set<String> friends2;
    /** 以电话号码作为key 以 名字作为value */
    private  Map<String,String> phones;
    private  Properties   phones2;
}




