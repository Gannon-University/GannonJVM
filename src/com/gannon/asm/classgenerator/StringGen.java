package com.gannon.asm.classgenerator;

public class StringGen {

	public static boolean filesSuffix(String file) {
		String[] fileparts = file.split("\\.");
		if(file.contains(".")) return false;
				
		int lastpart = fileparts.length - 1;
		if (lastpart > 0) {
			if (fileparts[lastpart].equals("exe")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(filesSuffix("test.exe"));

	}

}
