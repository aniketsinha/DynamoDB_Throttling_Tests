package com.aniket;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputExceededException;

/**
 * Tests Throttling of GetItem requests
 */
class ThrottleRead implements Runnable {
    private Stats stats;
    private AWSCredentials awsCredentials;
    ThrottleRead(AWSCredentials c,Stats s) {
        this.stats = s;
        this.awsCredentials = c;
    }
    @Override
    public void run() {

            try {
                TestsUtil util = new TestsUtil();
                String endPoint = String.format(util.DYNAMODB_ENDPOINT_FORMAT,util.TABLE_REGION);
                AmazonDynamoDBClient client = new AmazonDynamoDBClient(awsCredentials);
                client.setEndpoint(endPoint);
                DynamoDB dynamoDB = new DynamoDB(client);
                Table table = dynamoDB.getTable(util.TABLE_NAME);
                Item item = table.getItem("Artist", "No One You Know", "SongTitle", "My Dog Spot");
                System.out.println("("+Thread.currentThread().getName()+ ")\tItem = " + item );
                stats.incrementSuccessFulRequestCount();

            } catch (ProvisionedThroughputExceededException pte) {
                stats.incrementThrottledRequestCount();
                System.out.println("(" + Thread.currentThread().getName() + ")\tProvisionedThroughputExceededException occurred, exception = " + pte.getMessage());
            } catch (Exception e) {
                stats.incrementExceptionsCount();
                System.out.println("(" + Thread.currentThread().getName() + ")\tException occurred, exception = " + e.getMessage());
            }
        System.out.println("(" + Thread.currentThread().getName() + ") Successful Count = " + stats.getSuccessFulRequestsCount() + "\tThrottled Count = " + stats.getThrottledRequestsCount() + "\tException Count = " + stats.getExceptionsCount());
    }
}
