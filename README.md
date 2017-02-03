# DynamoDB Throttling Tests

DynamoDB charges money based on provisioned read and write capacity. You have to ensure you are not underprovisioning/overprovisioning your tables.
In case the table is underprovisioned, read and write requests will throttle, and in case of overprovisioning, you'll end up paying more money.

This project aims to provide idea about the throttling of requests based on provisioning. This sends multiple requests to DynamoDB using Threads and give stats on successful and throttled requests. 
