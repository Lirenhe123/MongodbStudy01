package mongodbStudy01;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class _02ConnectWithAuthority {
	public static void main(String[] args) {
		try{
			ServerAddress serverAddress=new ServerAddress("localhost",27017);
			List<ServerAddress> listOfServerAddress=new ArrayList<ServerAddress>();
			listOfServerAddress.add(serverAddress);
			
			//权限验证好像需要在.bat启动文件中配置
			MongoCredential credential=MongoCredential.
					createScramSha1Credential("", "newdb", "".toCharArray());
			
			
			List<MongoCredential> credentials=new ArrayList<MongoCredential>();
			credentials.add(credential);
			
			MongoClient mongoClient = new MongoClient(listOfServerAddress,credentials);
			MongoDatabase mongodb=mongoClient.getDatabase("newdb");
			
			System.out.println(mongodb);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
