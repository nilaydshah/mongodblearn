// HelloMongoDbSparkFreemarker.java - (insert one line description here)
// (C) Copyright 2014 Hewlett-Packard Development Company, L.P.

package in.nilayshah.mongodblearn;

import java.io.StringWriter;
import java.net.UnknownHostException;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 */
public class HelloMongoDbSparkFreemarker
{

    public static void main(final String[] args)
            throws UnknownHostException
    {

        final MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

        final DB database = client.getDB("test");
        final DBCollection collection = database.getCollection("mycollection");

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloMongoDbSparkFreemarker.class, "/");

        Spark.get(new Route("/")
        {
            @Override
            public Object handle(final Request arg0, final Response arg1)
            {
                final StringWriter writer = new StringWriter();
                try
                {
                    final Template helloTemplate = configuration.getTemplate("hello.ftl");

                    final DBObject document = collection.findOne();

                    helloTemplate.process(document, writer);

                }
                catch (final Exception e)
                {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;

            }
        });
    }
}
