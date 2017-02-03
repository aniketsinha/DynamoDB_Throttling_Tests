package com.aniket;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

/**
 * Contains utils needed to perform tests
 */
class TestsUtil {
    private static final String ACCESS_KEY = "AKIAIAWSAACCESSKEYID";
    private static final String PASSWORD = "rePlaCEYou70rgenertd+nsecretPassword+AWS";
    public final String DYNAMODB_ENDPOINT_FORMAT = "https://dynamodb.%s.amazonaws.com";
    public final String TABLE_NAME = "Music";
    public final String TABLE_REGION = "us-east-1";

    /**
     * Fetches AWSCredentials based on configured Access key id and password
     * @return AWSCredentials
     */
    public static AWSCredentials getAwsCredentials() {
        return new BasicAWSCredentials(ACCESS_KEY, PASSWORD);
    }
}
