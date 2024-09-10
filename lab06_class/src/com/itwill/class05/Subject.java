package com.itwill.class05;

public class Subject {
	
    // field
    int korean;
    int english;
    int math;
    int science;
    
    // TODO 생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    
    // 기본 생성자
    public Subject(){}
    
    // 아규먼트를 갖는 생성자
    public Subject(int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    
    
    // TODO 메서드: (1)총점 리턴. (2) 평균 리턴.
    
    public int getTotal() {
    	// this. 생략 가능.
    	return korean + english + math + science;
    }
    
    public double getMean() {
    	// this.getTotal() 가능
    	return (double) this.getTotal() / 4;
    }
    
    public void info() {
    	System.out.println("국어:" + this.korean);
    	System.out.println("영어:" + this.english);
    	System.out.println("수학:" + this.math);
    	System.out.println("과학:" + this.science);
    	System.out.println("총점:" + getTotal());
    	System.out.println("평균:" + getMean());
    }
    
  
}
