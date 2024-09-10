package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	private List<Contact> contacts = new ArrayList<>();
	
	

	
	
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }
	
	
	
    @Override
    public int create(Contact contact) {
       contacts.add(contact);
        return 1;
    }

    @Override
    public List<Contact> read() {
        return contacts;
    }

    @Override
    public Contact read(int index) {
    	if (index < contacts.size()) {
    		return contacts.get(index);
    	} else {
    		return null;	
    	}
    }
        
	@Override
	public int update(int index, Contact contact) {
		if (index < contacts.size()) {
			contacts.set(index, contact);
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public int delete(int index) {
		if (index < contacts.size()) {
			contacts.remove(index);
			return 1;
		} else {
			return 0;
		}
		
	}

}