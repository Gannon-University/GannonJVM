package com.gannon.asm.classgenerator;

public class StringGen1 {

	public static boolean filesSuffix(String file) {
		String[] fileparts = file.split("\\.");
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
