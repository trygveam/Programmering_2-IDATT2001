package edu.ntnu.idatt2001.trygveam.frivillig3;

import java.io.Serial;
import java.util.*;

class Paragrafer implements java.io.Serializable {
	private List<String> paragrafer = new ArrayList<String>();
	@Serial
	private static final long serialVersionUID = 1234567L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Paragrafer(List<String> paragrafer) {
 		this.paragrafer = paragrafer;
 	}

	public void addParagraf(String paragraf) {
		if (paragraf.isEmpty()) throw new IllegalStateException("Ikke lov å lagre tomme paragrafer!");

		paragrafer.add(paragraf);
	}
	
	public List<String> getParagrafer() {
		return paragrafer;
	}
	
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for (String paragraf : paragrafer) {
			temp.append(paragraf);
			temp.append(System.lineSeparator());
		}
		
		return temp.toString();
	}
}
