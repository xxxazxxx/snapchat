package com.mduggan92.snapchat.mailbox;

import java.util.List;

public class SingleSnap {
	//type of data
	public static final int PICTURE = 0;
	public static final int VIDEO = 1;
	
	//status of delivery
	public static final int RECEIVED = 3;
	public static final int OPENED = 4;

	public String username;
	public String timestamp;
	public int type;
	public int status;
	public boolean isGroup;
	public String action;
	public int i;
	
	public List<SingleSnap> groupstatus;
}
