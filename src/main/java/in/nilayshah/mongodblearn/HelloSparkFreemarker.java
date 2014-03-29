// HelloSparkFreemarker.java - (insert one line description here)
// (C) Copyright 2014 Hewlett-Packard Development Company, L.P.

package in.nilayshah.mongodblearn;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 */
public class HelloSparkFreemarker
{
    public static void main(final String[] args)
    {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloFreemarker.class, "/");

        Spark.get(new Route("/")
        {
            @Override
            public Object handle(final Request arg0, final Response arg1)
            {
                StringWriter writer = null;
                try
                {
                    final Template helloTemplate = configuration.getTemplate("hello.ftl");
                    writer = new StringWriter();
                    final Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Freemarker");

                    helloTemplate.process(helloMap, writer);

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
