package com.aniket;

import com.amazonaws.auth.AWSCredentials;

/**
 * Main class to begin tests
 */
public class Main {

    public static void main(String[] args) {
	    Stats stats = new Stats();
        int numberOfThreads = 1200;
        AWSCredentials awsCredentials = TestsUtil.getAwsCredentials();
        for(int i=0; i<numberOfThreads;i++) {
            Thread readThread = new Thread(new ThrottleRead(awsCredentials,stats));
            readThread.start();
        }

    }
}
