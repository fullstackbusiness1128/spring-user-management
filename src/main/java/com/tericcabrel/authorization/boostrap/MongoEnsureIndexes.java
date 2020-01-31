package com.tericcabrel.authorization.boostrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

import com.tericcabrel.authorization.models.mongo.Role;
import com.tericcabrel.authorization.models.mongo.User;

@Component
public class MongoEnsureIndexes implements ApplicationListener<ContextRefreshedEvent> {
    private MongoTemplate mongoTemplate;

    public MongoEnsureIndexes(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        mongoTemplate.indexOps(User.class).ensureIndex(
                new Index().on("email", Sort.Direction.ASC).background().unique()
        );

        mongoTemplate.indexOps(Role.class).ensureIndex(
                new Index().on("name", Sort.Direction.ASC).unique()
        );
    }
}
