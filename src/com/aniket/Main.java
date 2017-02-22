package com.aniket;

import com.amazonaws.auth.AWSCredentials;

/**
 * Main class to begin tests
 */
public class Main {

    public static void main(String[] args) {
	Stats stats = new Stats();
        int numberOfThreads = 100;
        AWSCredentials awsCredentials = TestsUtil.getAwsCredentials();
	try {
		System.out.println("Initiating test...");
		for(int j=1;j<=15;j++) {
			System.out.println(" o_o Thread awake...");			
			for(int i=0; i<numberOfThreads;i++) {
			    Thread readThread = new Thread(new ThrottleRead(awsCredentials,stats));
			    readThread.start();
			}
			System.out.println(" -_- Thread going to sleep...");
		        Thread.sleep(5000);
		}
		System.out.println("Test complete!");
	}
	catch(Exception e) {
	    System.out.println("Exception occured, e="+e);
	}
    }
}
