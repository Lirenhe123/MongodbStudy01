package mongodbStudy01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class _01ConnectMongodb {
	public static void main(String[] args) {
		try{
			MongoClient mongodbClient=new MongoClient("localhost",27017);
			MongoDatabase mongodb=mongodbClient.getDatabase("mycol");
			if(mongodb!=null){
				System.out.println(mongodb);
			}
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
	}
}
