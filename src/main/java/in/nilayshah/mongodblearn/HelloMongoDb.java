package in.nilayshah.mongodblearn;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Hello world!
 * 
 */
public class HelloMongoDb
{
    public static void main(final String[] args)
            throws UnknownHostException
    {
        System.out.println("Hello MongoDB!");
        final MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        final DB database = client.getDB("test");
        final DBCollection collection = database.getCollection("mycollection");

        final DBObject document = collection.findOne();
        System.out.println(document);
    }
}
