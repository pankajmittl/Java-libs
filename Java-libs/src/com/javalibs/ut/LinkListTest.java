package com.javalibs.ut;

import com.javalib.graph.LinkList;
import com.javalib.graph.Node;

public class LinkListTest {
	
	public static void printLinkList(Node n)
	{
		while(n!=null)
		{
			System.out.print(n.value+"->");
			n = n.next;
		}
		System.out.println("null");
	}
	
	public boolean reverseTest()
	{
		Node nd = new Node();
		nd.value = 1;
		nd.next = new Node();
		nd.next.value = 2;
		nd.next.next = new Node();
		nd.next.next.value = 3;
		nd.next.next.next = null;
		printLinkList(nd);
		
		Node temp = LinkList.reverse(nd);
		printLinkList(temp);
		
		return true;
	}

	public boolean runTests() {
		
		if(!reverseTest()) return false;
		
		return true;
	}

}
