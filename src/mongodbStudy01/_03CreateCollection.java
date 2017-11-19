package mongodbStudy01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class _03CreateCollection {
	public static void main(String[] args) {
		try{
		/*	MongoClient mongoClient=new MongoClient("localhost",27017);
			MongoDatabase mongodb=mongoClient.getDatabase("newdb");
			mongodb.createCollection("test");*/
			
			MongoClient mongoClient=new MongoClient("localhost",27017);
			MongoDatabase mongodb=mongoClient.getDatabase("newdb");
			MongoCollection mongoCollection01=mongodb.getCollection("test");
			System.out.println(mongoCollection01);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
