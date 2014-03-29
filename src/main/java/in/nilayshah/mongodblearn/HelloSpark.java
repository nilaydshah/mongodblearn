// HelloSpark.java - (insert one line description here)
// (C) Copyright 2014 Hewlett-Packard Development Company, L.P.

package in.nilayshah.mongodblearn;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * 
 */
public class HelloSpark
{

    public static void main(final String[] args)
    {

        Spark.get(new Route("/")
        {
            @Override
            public Object handle(final Request arg0, final Response arg1)
            {
                return "Hello Spark!";
            }
        });
    }
}
