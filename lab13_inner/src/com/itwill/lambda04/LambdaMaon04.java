package com.itwill.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMaon04 {

	public static void main(String[] args) {
		// 사원(Employee)들의 리스트
		
		List<Employee> employees = Arrays.asList(
				new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800),
				new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1000),
				new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900),
				new Employee(107, "오쌤", "총무", "대리", 300)
				);
		
		// Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
		System.out.println("------ Ex.1 -----");
		employees.forEach(System.out::println);
		
		// Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계
		// Ex3. 개발(1, 2)팀에서 일하는 직원들의 급여 평균
		
		// Ex 2,3 for문을 이용한 계산법
		System.out.println("------ Ex.2  Ex.3 -----");
		double sum = 0; // 급여 합계를 저장하기 위한 변수
		int count = 0; // 개발팀 직원수를 저장하기 위한 변수
		for(Employee x : employees) {
			if(x.getDept().contains("개발")) { // 직원의 부서 이름이 "개발" 을 포함하면
				sum += x.getSalary();
				count ++;
			}
		}
		System.out.println("개발 1, 2팀 급여 합계 : " + sum);
		System.out.println("개발 1, 2팀 급여 평균 : " + sum/count);
		

		// Ex 2,3 람다 및 Stream 클래스를 이용한 계산법
		sum = employees.stream().filter(x -> x.getDept().contains("개발")).mapToDouble((x) -> x.getSalary()).sum();
		System.out.println("sum : " + sum);
		System.out.println("sum의 평균 : " + sum/count);

		
		// Ex4. 직급이 부장인 직원들의 급여 합계
		System.out.println("------ Ex.4  Ex.5 -----");
		sum = employees.stream().filter(x->x.getJobTitle().equals("부장")).mapToDouble(x->x.getSalary()).sum();
		System.out.println("부장들의 급여 : " + sum);
		
		// Ex5. 직급이 부장인 직원들의 급여 평균
		double avr = employees.stream().filter(x->x.getJobTitle().equals("부장")).mapToDouble(x->x.getSalary()).average().orElseThrow();
		// 평균을 계산 할 수 있으면 double 값을 리턴, 그렇지 않으면 예외를 발생
		System.out.println("부장들의 평균 급여 : " + avr);
		
		System.out.println("------ Ex.6  Ex.7 -----");
		// Ex6. 급여가 1000 이상인 직원들의 정보를 한 줄에 한 명씩
		employees.stream().filter(x -> x.getSalary() >= 1000).forEach(System.out::println);
		
		// Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 금여의 평균
		double money = employees.stream().filter(x->x.getDept().equals("개발1팀")).mapToDouble(x -> x.getSalary() * 1.1).average().orElseThrow();
		System.out.println("연봉 10% 이상된 개발 1팀의 평균 급여 : " + money);
		
		
		
//		sum = 0.0; // 개발 1팀 직원들의 10% 인상한 급여 합계 	
//		count = 0;
//		for (Employee e : employees) {
//			if (e.getDept().equals("개발1팀")) {
//				sum += e.getSalary() * 1.1;
//				count ++;
//			}
//		}
		
		// Ex8. 직원들 중 대리는 몇 명?
		long ksm = employees.stream().filter(x -> x.getJobTitle().equals("대리")).count();
		System.out.println("대리 인원 : " + ksm);
		
	}

}
