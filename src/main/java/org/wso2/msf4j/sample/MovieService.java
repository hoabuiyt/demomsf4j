package org.wso2.msf4j.sample;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.wso2.msf4j.Microservice;
import org.wso2.msf4j.sample.Movie;
import org.wso2.msf4j.sample.exception.DuplicateSymbolException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@Api(value = "stockquote2")
@SwaggerDefinition(info = @Info(title = "Stockquote Swagger Definition", version = "1.0", description = "Stock quote service", license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"), contact = @Contact(name = "Afkham Azeez", email = "azeez@wso2.com", url = "http://wso2.com")))

@EnableMongoRepositories
@Path("/stockquote2")
public class MovieService implements Microservice {

	@Autowired
	private MovieRepository repository;
	MongoClient mongo;

	public MovieService() {

	}

	@GET
	@Path("/all")
	public String getAllStocks() {
		System.out.println("get du lieu");
		
		try {
			mongo = new MongoClient("localhost", 27017);
			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("testdb");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("user");

			/**** Insert ****/
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", "mkyong");
			document.put("age", 30);
			document.put("createdDate", new Date());
			table.insert(document);

			System.out.println("Done");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Done";
	}

	@POST
	@Consumes("application/json")
	@ApiOperation(value = "Add a Movie item", notes = "Add a valid Movie item")
	public void addStock(@ApiParam(value = "Movie object", required = true) Movie movie)
			throws DuplicateSymbolException {

		System.out.println("post du lieu");
		repository.save(movie);
	}

}
