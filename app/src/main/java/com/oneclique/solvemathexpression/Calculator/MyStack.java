package com.oneclique.solvemathexpression.Calculator;

public class MyStack <DataType>{
	private Node<DataType> head;
	private int size = 0;
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void push(DataType data){
		Node<DataType> newStackNode = new Node<DataType>();
		newStackNode.data = data;
		newStackNode.nextNode = head; 
		head = newStackNode;
		size++;
	}
	
	public DataType pop(){
		Node<DataType> iter = head;
		Node<DataType> newStackNode = new Node<DataType>();
		if(isEmpty()){
			return null;
		}
		else{
			DataType data = iter.data;
			iter = iter.nextNode;
			newStackNode = iter;
			size--;
			head = newStackNode;
			return data;
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public void printStack(){
		Node<DataType> iter = head;
		if(isEmpty()){
			System.out.print("Stack is Empty");
		}
		else{
			while(iter != null){
				System.out.print(iter.data + " ");
				iter = iter.nextNode;
			}
		}
	}
	
}
