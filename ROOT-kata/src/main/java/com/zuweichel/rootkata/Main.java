package com.zuweichel.rootkata;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Long start = System.currentTimeMillis();
		File inFile = null;
		if (0 < args.length) {
		   inFile = new File(args[0]);
		} else {
		   System.err.println("Invalid arguments count:" + args.length);
		   System.exit(0);
		}
		
		Menu menu = new Menu(System.out , inFile);
		menu.run();
		System.out.println(System.currentTimeMillis()-start+" miliseconds");
	}
	
}
