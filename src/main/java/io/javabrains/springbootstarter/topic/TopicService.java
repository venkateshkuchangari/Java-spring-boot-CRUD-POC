package io.javabrains.springbootstarter.topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<> ( Arrays.asList(
			new Topic("Spring","Spring boot","Spring boot framework"),
			new Topic("UI","Angular","Angular framework")
			)
	);
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getSpecificTopic(String id) {
		return topics.stream().filter(ele -> ele.getId().equals(id)).findFirst().get();
	}

	public void postSpecificTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateSpecificTopic(Topic topic, String id) {
		for(int i=0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
			   topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		
		// Approach - I
//		for(int i=0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.remove(i);
//				return;
//			}
//		}
		
		// Approach - II
		topics.removeIf(t -> t.getId().equals(id));
	}

}
