package com.project.helloworld.service;

public interface VisitorService {
    void addVisitor(String email, String visitorId);
    Long getTotalVisitors(String ownerSeq);
    Long getTodayVisitors(String ownerSeq);
    void expireTodayVisitors(String ownerSeq);
}
