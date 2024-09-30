package util;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import models.AI;

public class MongoConnect {
	private static MongoDatabase db;
	private static MongoClient mc;
	private static MongoCollection<AI> ai1;
	public static MongoClient getClient() {
		if(mc != null)
			return mc;
		ConnectionString connectionString = new ConnectionString(
				"mongodb+srv://bot:bot@cluster0.7zhwb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
		CodecRegistry pojoCodecRegistry = CodecRegistries
				.fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				pojoCodecRegistry);
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.codecRegistry(codecRegistry).build();
		mc = MongoClients.create(clientSettings);
		return mc;
	}
	public static MongoDatabase getDatabase() {
		if (db != null)
			return db;
		db = getClient().getDatabase("PRVAI");
		return db;
	}

	public static MongoCollection<AI> getCollection() {
		if (ai1 != null)
			return ai1;
		ai1 = getDatabase().getCollection("Ai1", AI.class);
		return ai1;
	}
}