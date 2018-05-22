package com.revature.name;

import java.util.List;

import com.revature.beans.Flashcard;
import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		/*
		Session s = HibernateUtil.getSession();
		System.out.println(s.getStatistics());
		System.out.println(s.isOpen());
		s.close();
		System.out.println(s.isOpen());
		*/
		
		init();
		
	}	
	
	public static void init() {
		
	
		
/*		Session s = HibernateUtil.getSession();
		System.out.println(s.isOpen());
		s.close();
		System.out.println(s.isOpen()); */
		
		FlashcardDao fd = new FlashcardDaoImpl();
		Flashcard f1 = new Flashcard("What is Java?", "The best language.");
		Flashcard f2 = new Flashcard("Is it raining?", "Not right now, maybe.");
		
		//fd.addFlashcard(f1);
		//fd.addFlashcard(f2);
		
		
		List<Flashcard> fcl = fd.getFlashcards();
		
		for (Flashcard f : fcl) {
			System.out.println(f);
		}
	
	}
}
