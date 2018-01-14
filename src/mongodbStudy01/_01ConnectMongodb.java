package mongodbStudy01;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.util.JSON;

public class _01ConnectMongodb {
	public static void main(String[] args) {
		try{
//			Mongo mongo = new Mongo();
			MongoClient mongodbClient=new MongoClient("localhost",27017);
			MongoIterable<String> mongoIterable = mongodbClient.listDatabaseNames();
			MongoCursor<String> mongoCursor = mongoIterable.iterator();
			while(mongoCursor.hasNext()){
				System.out.println("数据库名："+mongoCursor.next());
			}
			
			MongoDatabase mongodb=mongodbClient.getDatabase("foobar");
			if(mongodb!=null){
				System.out.println("当前数据库名："+mongodb.getName());
			}
			MongoIterable<String> collectionNamesIterable = mongodb.listCollectionNames();
			MongoCursor<String>  nameCursor = collectionNamesIterable.iterator();
			while(nameCursor.hasNext()){
				System.out.println("集合名："+nameCursor.next());
			}
			
			MongoCollection<Document> mongoCollection = mongodb.getCollection("persons");
			FindIterable<Document> findIterable = mongoCollection.find();
			MongoCursor<Document> findCursor = findIterable.iterator();
			while(findCursor.hasNext()){
				Document document = findCursor.next();
				System.out.println("persons.name:"+document.get("name"));
			}
			System.out.println(mongoCollection.count());//该框架的猜测：mongoCollection可以集合类型的操作  findIterable：mogo数据库类型的操作   findCursor：数据类型操作
			System.out.println(JSON.serialize(findIterable));
		}catch(Exception e){
			System.out.println(e.getClass().getName()+":"+e.getMessage());
		}
	}
}
