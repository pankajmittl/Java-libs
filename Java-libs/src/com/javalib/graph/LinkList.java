package com.javalib.graph;

public class LinkList {
		
	//linklist add
	
	//linklist add at index
	
	//linklist delete
	
	//linklist delete at index
	
	//linklist reverse
	public static Node reverse(Node node)
	{
		Node nxt = node.next;
		Node pv = null;
		Node nd = node;
		
		while(true)
		{
			nd.next = pv;
			pv = nd;
			nd = nxt;
			nxt = nd.next;
			
			if(nxt == null) {
				nd.next = pv;
				break;
			}
		}
		
		return nd;
	}
	
	//linklist find joint in two headed list
	
	//circular list

}
