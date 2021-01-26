package org.example.s3;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.amazonaws.services.lambda.runtime.Context;

public class S3Operations {

    Properties properties;
    Context context;

    public S3Operations(Context context) throws IOException {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw e;
        }
    }


    public void listS3Bucket() {

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration((new AwsClientBuilder.EndpointConfiguration(properties.getProperty("s3.endpoint"),
                properties.getProperty("s3.region")))).build();

        s3Client.listBuckets().stream().forEach(bucket -> context.getLogger().log(bucket.getName() + "\n"));

    }

}
