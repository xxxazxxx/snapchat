package com.mduggan92.snapchat;

import java.util.ArrayList;
import java.util.List;

import com.mduggan92.snapchat.mailbox.SingleSnap;

public class Data {

	private static String TAG = "DATA";
	public static int NUM_ITEMS = 8;
	private static String[] names = { "Amelia Bauer", "Mike Duggan",
			"John Smith", "Lady Gaga", "Professor D'Mello", "Matthew Pardy",
			"Joe Adams", "Sam Jones" };
	private static String[] usernames = { "NDaMillie", "mduggan92", "jsmith",
			"lgg", "dmello", "mparty", "adams", "sjones18" };

	private static int[] type = { SingleSnap.VIDEO, SingleSnap.PICTURE,
			SingleSnap.PICTURE, SingleSnap.VIDEO, SingleSnap.VIDEO,
			SingleSnap.PICTURE, SingleSnap.PICTURE, SingleSnap.VIDEO };
	private static int[] status = { SingleSnap.RECEIVED, SingleSnap.OPENED,
			SingleSnap.RECEIVED, SingleSnap.RECEIVED, SingleSnap.OPENED,
			SingleSnap.OPENED, SingleSnap.OPENED, SingleSnap.RECEIVED };

	private static String[] draftnames = { "Recipients Unspecified",
			"Mike Duggan", "Recipients Unspecified", "Lady Gaga",
			"Amelia Bauer", "Matthew Pardy", "Joe Adams", "Sam Jones" };

	private static String getName(int i) {
		return names[i];
	}

	private static int getType(int i) {
		return type[i];
	}

	private static int getStatus(int i) {
		return status[i];
	}

	public static User getUser(int i) {
		User temp = new User();
		temp.username = usernames[i];
		temp.name = names[i];
		return temp;
	}

	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		User best = new User();
		best.name = "Best Friends";
		best.isSection = true;
		users.add(best);
		users.add(getUser(4));
		users.add(getUser(1));
		users.add(getUser(3));

		User groups = new User();
		groups.name = "Groups";
		groups.isSection = true;
		users.add(groups);
		User ski = new User();
		ski.name = "Ski Team";
		ski.username = "Tap to view/edit";
		ski.isGroup = true;
		users.add(ski);

		User a = new User();
		a.name = "A";
		a.isSection = true;
		users.add(a);
		users.add(getUser(0));
		
		User j = new User();
		j.name = "J";
		j.isSection = true;
		users.add(j);
		users.add(getUser(6));
		users.add(getUser(2));
		User l = new User();
		l.name = "L";
		l.isSection = true;
		users.add(l);
		users.add(getUser(3));
		User m = new User();
		m.name = "M";
		m.isSection = true;
		users.add(m);
		users.add(getUser(5));
		users.add(getUser(1));
		
		User d = new User();
		d.name = "P";
		d.isSection = true;
		users.add(d);
		users.add(getUser(4));
		
		User s = new User();
		s.name = "S";
		s.isSection = true;
		users.add(s);
		users.add(getUser(7));

		return users;
	}

	public static void getOutboxInfo(SingleSnap snap) {
		String temp = "";
		int i = snap.i;
		switch (snap.status) {
		case SingleSnap.OPENED:
			temp += "Opened - ";
			snap.action = "Tap to reply";
			break;
		case SingleSnap.RECEIVED:
			temp += "Received - ";
			snap.action = "Press and hold to view";
			break;
		default:
			break;
		}
		i++;
		temp += i;
		if (i == 1)
			temp += " Hour Ago";
		else
			temp += " Hours Ago";
		snap.timestamp = temp;

		if (snap.isGroup) {
			snap.timestamp += " - Tap to view group";
		}

	}

	public static SingleSnap getOutboxSnap(int i) {
		if (i >= NUM_ITEMS) {
			SingleSnap group = new SingleSnap();
			group.username = "Ski Team";
			group.isGroup = true;
			group.type = SingleSnap.PICTURE;
			group.groupstatus = getInboxSnaps();
			group.i = 2;
			getOutboxInfo(group);
			return group;
		}

		SingleSnap snap = new SingleSnap();
		snap.username = getName(i);
		snap.type = getType(i);
		snap.status = getStatus(i);
		snap.i = i + 1;
		getOutboxInfo(snap);
		return snap;
	}

	public static List<SingleSnap> getListSnaps() {
		ArrayList<SingleSnap> snaps = new ArrayList<SingleSnap>();
		for (int i = 0; i < NUM_ITEMS; i++)
			snaps.add(getOutboxSnap(i));

		return snaps;
	}

	public static List<SingleSnap> getOutboxSnaps() {
		ArrayList<SingleSnap> snaps = new ArrayList<SingleSnap>();
		for (int i = 0; i < NUM_ITEMS; i++)
			snaps.add(getOutboxSnap(i));

		SingleSnap group = new SingleSnap();
		group.username = "Ski Team";
		group.type = SingleSnap.PICTURE;
		group.groupstatus = getInboxSnaps();
		group.i = 2;
		getOutboxInfo(group);
		snaps.add(group);

		return snaps;
	}

	public static void getInboxInfo(SingleSnap snap) {
		String temp = "";
		int i = snap.i;
		switch (snap.status) {
		case SingleSnap.OPENED:
			temp += "Opened - ";
			snap.action = "Tap to reply";
			break;
		case SingleSnap.RECEIVED:
			temp += "Unopened - ";
			snap.action = "Press and hold to view";
			break;
		default:
			break;
		}

		i++;
		temp += i;
		if (i == 1)
			temp += " Hour Ago";
		else
			temp += " Hours Ago";
		snap.timestamp = temp;

	}

	public static SingleSnap getInboxSnap(int i) {
		SingleSnap snap = new SingleSnap();
		snap.username = getName(i);
		snap.type = getType(i);
		snap.status = getStatus(i);
		snap.i = i;
		getInboxInfo(snap);
		return snap;
	}

	public static ArrayList<SingleSnap> getInboxSnaps() {
		ArrayList<SingleSnap> snaps = new ArrayList<SingleSnap>();
		for (int i = 0; i < NUM_ITEMS; i++)
			snaps.add(getInboxSnap(i));
		return snaps;
	}

	public static SingleSnap getDraftSnap(int i) {
		SingleSnap snap = new SingleSnap();
		snap.username = draftnames[i];
		snap.type = getType(i);
		snap.i = i;
		getDraftInfo(snap);

		return snap;
	}

	public static void getDraftInfo(SingleSnap snap) {
		String temp = "";
		int i = snap.i;
		temp += "Created - ";
		i++;
		temp += i;
		if (i == 1)
			temp += " Hour Ago";
		else
			temp += " Hours Ago";
		snap.timestamp = temp;
		snap.action = "Tap to modify";

	}

	public static List<SingleSnap> getDraftSnaps() {
		ArrayList<SingleSnap> snaps = new ArrayList<SingleSnap>();
		for (int i = 0; i < NUM_ITEMS; i++)
			snaps.add(getDraftSnap(i));
		return snaps;
	}

}
