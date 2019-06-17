package src.main.java.edu.handong.cess;

import java.util.HashMap;

public class ListNode {
	private HashMap<String, ForArrayList> data;
	private ListNode link;
	
	private ListNode head=null;
	private ListNode current;
	
	public void setCurrent(ListNode current) {
		this.current = current;
	}

	public ListNode getCurrent() {
		return current;
	}

	private ListNode previous;
	
	public ListNode() {
		link = null;
		data = null;
	}
	
	public ListNode(HashMap<String, ForArrayList> newData, ListNode linkedNode) {
		data = newData;
		link = linkedNode;
	}

	public HashMap<String, ForArrayList> getData() {
		return data;
	}

	public void setData(HashMap<String, ForArrayList> data) {
		this.data = data;
	}


	public void insertNodeAfterCurrent(HashMap<String, ForArrayList> newData) {
		ListNode newNode = new ListNode();
		newNode.data = newData;
		if(current != null) {
			newNode.link = current.link;
			current.link = newNode;
		}else if(head != null) {
			System.out.println("Inserting when iterator is past all nodes or is not initialzed");
			System.exit(0);
		}else {
			System.out.println("Using insertNodeAfterCurrent with empty list.");
			System.exit(0);
		}
	}
	
	public ListNode getLink() {
		return link;
	}
	
	public void setLink(ListNode link) {
		this.link = link;
	}
	
	
}