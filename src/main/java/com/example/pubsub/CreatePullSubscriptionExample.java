package com.example.pubsub;

/*
 * Creates a new subscription and this is assigned to a created topic
 */

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;

public class CreatePullSubscriptionExample {


  public static void main(String[] args) throws Exception {

    
    String projectId = ServiceOptions.getDefaultProjectId();

    
    String topicId = "topic_101";

    
    String subscriptionId = "mysub101";

    ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);

    // Create a new subscription
    ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(
        projectId, subscriptionId);
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // create a pull subscription with default acknowledgement deadline (= 10 seconds)
      Subscription subscription =
          subscriptionAdminClient.createSubscription(
              subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
    } catch (ApiException e) {
      
      System.out.println(e.getStatusCode().getCode());
     
    }

    System.out.printf(
        "Subscription %s:%s created.\n",
        subscriptionName.getProject(), subscriptionName.getSubscription());
  }
}
