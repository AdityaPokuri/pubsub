package com.example.pubsub;

import java.io.File;

// [START pubsub_quickstart_create_topic]
// Imports the Google Cloud client library

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.ProjectTopicName;

/*
 * This class creates a topic if not already exists.
 */
public class CreateTopicExample {

 
  public static void main(String[] args) throws Exception {

    
    String projectId = ServiceOptions.getDefaultProjectId();
    System.out.println(projectId);
    
    
    String topicId = "topic_101";
    
    // Create a new topic
    ProjectTopicName topic = ProjectTopicName.of(projectId, topicId);
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.createTopic(topic);
    } catch (ApiException e) {
      
      System.out.println(e.getStatusCode().getCode());
      
    }

    System.out.printf("Topic %s:%s created.\n", topic.getProject(), topic.getTopic());
  }
}
