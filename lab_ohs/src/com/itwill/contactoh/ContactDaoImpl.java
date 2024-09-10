package com.itwill.contactoh;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
    //----- singleton
    private static ContactDaoImpl instance = null; 
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //----- singleton

    private Contact[] contacts = new Contact[MAX_LENGTH]; // Contact 타입의 배열을 생성하고 인덱스는 MAX_LENGTH
    
    private int count = 0;  // 전체 저장 공간 횟수를 카운트 해주는 변수
    
    public boolean isMemoryFull() { // count가 MAX_LENGTH와 값이 같으면 true 다르면 false
        return (count == MAX_LENGTH);
    }
    
    public boolean isValidIndex(int index) { // 인덱스가 0 이상 count 미만이면 true 아니면 false
        return (index >= 0) && (index < count);
    }
    
    @Override
    public int create(Contact contact) { // 만약 isMemoryFull 메소드 조건에 맞으면 배열 counts 인덱스에 저장하고
        if (isMemoryFull()) {            // count 변수에 1을 더해라 그렇지 않으면 작동하지 말아라 
            return 0;
        }
        contacts[count] = contact;
        count++;
        
        return 1;
    }

    @Override
    public Contact[] read() { // contacts 배열 전체를 리턴
        return contacts;
    }

    @Override
    public Contact read(int index) { // 만약 isValidIndex 조건에 만족하면 아규먼트 값의 인덱스 배열을 리턴
        if (isValidIndex(index)) {   // isValidIndex 메소드 조건부에 충족하지 않으면 null을 리턴
            return contacts[index];
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, Contact contact) { //contact[index]에 Contact객체인 contact 변수를 넣어라
        if (isValidIndex(index)) {
            contacts[index] = contact;
            return 1;
        } else {
            return 0;
        }
    }
    
	@Override
	public int update(int index, Contact contact) { // getter를 이용한 수정
		is (isValidIndex(index) && countact != null){
			contacts[index].setName(contact.getName());
			contacts[index].setPhone(contact.getPhone());
			contacts[index].setEmail(contact.getEmail());
			return 1;
		} else {
			return 0;
		}
		
	}

}